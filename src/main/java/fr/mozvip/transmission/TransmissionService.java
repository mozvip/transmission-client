
package fr.mozvip.transmission;

import fr.mozvip.transmission.model.TransmissionResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TransmissionService {
	
	@POST("rpc")
	Call<Void> init();
	
	@POST("rpc")
	Call<TransmissionResponse> sendRequest(@Body TransmissionRequest request);
	

}
