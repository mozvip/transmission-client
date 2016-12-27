package fr.mozvip.transmission;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import fr.mozvip.transmission.model.Torrent;
import fr.mozvip.transmission.model.TransmissionResponse;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class TransmissionClient {
	
	public static final class Builder {
		
		private String baseUrl = "http://localhost:9091/transmission/";
		private String username;
		private String password;
		
		public Builder baseUrl( String baseUrl ) {
			this.baseUrl = baseUrl;
			return this;
		}
		
		public Builder username( String username ) {
			this.username = username;
			return this;
		}
		
		public Builder password( String password ) {
			this.password = password;
			return this;
		}
		
		public TransmissionClient build() throws IOException {
			return new TransmissionClient( baseUrl, username, password );
		}
		
	}

	private TransmissionClient(String baseUrl, String username, String password) throws IOException {
		this.baseUrl = baseUrl;
		this.username = username;
		this.password = password;
		
		init();
	}

	public static Builder Builder() {
		return new Builder();
	}

	private String baseUrl;
	private String username;
	private String password;

	private TransmissionService service = null;

	private long extractTorrentId( TransmissionResponse response ) {
		if (response.getArguments().getTorrentDuplicate() != null) {
			return response.getArguments().getTorrentDuplicate().getId();
		}
		if (response.getArguments().getTorrentAdded() != null) {
			return response.getArguments().getTorrentAdded().getId();
		}
		else return -1;
	}
	
	public long downloadTorrent( byte[] torrentData ) throws IOException {
		TransmissionRequest request = new TransmissionRequest( "torrent-add" );
		request.getArguments().setMetainfo( Base64.getEncoder().encodeToString( torrentData ) );
		return extractTorrentId( executeRequest(request) );
	}

	public long downloadByUrl( String url ) throws IOException {
		TransmissionRequest request = new TransmissionRequest( "torrent-add" );
		request.getArguments().setFilename( url );
		return extractTorrentId( executeRequest(request) );
	}
	
	public String stop(long id) throws IOException {
		TransmissionRequest request = new TransmissionRequest( "torrent-stop" );
		List<Long> ids = new ArrayList<>();
		ids.add( id );
		request.getArguments().setIds(ids);
		return executeRequest(request).getResult();
	}

	public String remove(long id, boolean deleteLocalData) throws IOException {
		TransmissionRequest request = new TransmissionRequest( "torrent-remove" );
		List<Long> ids = new ArrayList<>();
		ids.add( id );
		request.getArguments().setIds(ids);
		request.getArguments().setDeleteLocalData( deleteLocalData );
		return executeRequest(request).getResult();
	}

	public List<Torrent> getTorrents() throws IOException {
		TransmissionRequest request = new TransmissionRequest( "torrent-get" );
		request.getArguments().setFields( new String[] {"id", "name", "totalSize", "downloadedEver", "files", "doneDate", "downloadDir", "uploadRatio", "status"} );
		TransmissionResponse executeRequest = executeRequest(request);
		return executeRequest.getArguments().getTorrents();
	}

	private TransmissionResponse executeRequest( TransmissionRequest request ) throws IOException {
		retrofit2.Response<TransmissionResponse> response = service.sendRequest(request).execute();
		return response.body();
	}
	
	private String authorizationHeader = null;
	private String xTransmissionSessionIdHeader = null;
	
	private void init() throws IOException {
		
		if (username != null && password != null) {
			String loginAndPassword = username + ":" + password;
			authorizationHeader = String.format("Basic %s", Base64.getEncoder().encodeToString( loginAndPassword.getBytes() ));
		} else {
			authorizationHeader = null;
		}
		
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();  
		httpClient.addInterceptor(new Interceptor() {  
		    @Override
		    public Response intercept(Interceptor.Chain chain) throws IOException {
		        Request original = chain.request();
		        
		        // Request customization: add request headers
		        Request.Builder requestBuilder =original.newBuilder();

		        if (authorizationHeader != null) {
		        	requestBuilder.header("Authorization", authorizationHeader);
		        }
		        if (xTransmissionSessionIdHeader != null) {
		        	requestBuilder.header("X-Transmission-Session-Id", xTransmissionSessionIdHeader);
		        }
		        Request request = requestBuilder.build();
		        Response response = chain.proceed(request);
		        xTransmissionSessionIdHeader = response.header("X-Transmission-Session-Id", xTransmissionSessionIdHeader);
		        return response;
		        
		    }
		});

		OkHttpClient client = httpClient.build();
		
		if (!baseUrl.endsWith("/")) {
			baseUrl += "/";
		}

		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl( baseUrl )
			.addConverterFactory( JacksonConverterFactory.create() )
			.client( client )
			.build();
		service = retrofit.create(TransmissionService.class);
		retrofit2.Response<Void> response = service.init().execute();
		if (!response.isSuccessful() && !(response.code() == 409)) {
			throw new IOException( response.message() );
		}

	}	
}
