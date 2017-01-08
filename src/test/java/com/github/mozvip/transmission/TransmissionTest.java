package com.github.mozvip.transmission;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mozvip.transmission.TransmissionClient;
import com.github.mozvip.transmission.model.Torrent;

public class TransmissionTest {
	
	String torrentURL = "magnet:?xt=urn:btih:69D1D71B007B0E4EF685089D5EFBF49444488044&dn=%5BUbuntu.Linux.6.06%5D.ubuntu-6.06-server-i386.iso";

	static TransmissionClient transmission;
	
	@BeforeClass
	public static void init() throws IOException {
		transmission = TransmissionClient.Builder()
			.baseUrl("http://localhost:9091/transmission")
//			.username("test")
//			.password("test")
			.build();
	}

	@Test
	public void testGetTorrents() throws IOException {
		List<Torrent> torrents = transmission.getTorrents();
		for (com.github.mozvip.transmission.model.Torrent transmissionResponseTorrent : torrents) {
			System.out.println( transmissionResponseTorrent.getName() );
		}
	}

	@Test
	public void testAddTorrentByMagnetUrl() throws IOException {
		long torrentId = transmission.downloadByUrl(torrentURL);
		List<Torrent> torrents = transmission.getTorrents();
		int previousSize = torrents.size();
		assert(previousSize > 0);
		transmission.remove(torrentId, true);
		torrents = transmission.getTorrents();
		assert(torrents.size() == previousSize - 1);
	}

	@Test
	public void testAddTorrentByPath() throws IOException, URISyntaxException {
		URL url = this.getClass().getClassLoader().getResource("ubuntu-16.10-server-amd64.iso.torrent");
		Path torrentFilePath = Paths.get( url.toURI() );
		byte[] bytes = Files.readAllBytes( torrentFilePath );
		long torrentId = transmission.downloadTorrent( bytes );
		List<Torrent> torrents = transmission.getTorrents();
		
		for (Torrent torrent : torrents) {
			if (torrent.getId() == torrentId) {
				assert(torrent.getFiles().size() == 1);
			}
		}		
		
		int previousSize = torrents.size();
		assert(previousSize > 0);
		transmission.remove(torrentId, true);
		torrents = transmission.getTorrents();
		assert(torrents.size() == previousSize - 1);
	}

	@Test
	public void testStopTorrent() throws IOException {
		long torrentId = transmission.downloadByUrl(torrentURL);
		transmission.stop( torrentId );
		List<Torrent> torrents = transmission.getTorrents();
		
		for (Torrent torrent : torrents) {
			if (torrent.getId() == torrentId) {
				assert(torrent.getStatus() == Torrent.STOPPED);
			}
		}
		
		transmission.remove(torrentId, true);
	}

}
