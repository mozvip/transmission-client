# transmission-client
A Transmission Client in Java

Creating an instance of TransmissionClient

		TransmissionClient transmission = TransmissionClient.Builder()
			.baseUrl("http://localhost:9091/transmission")
			.username("test")
			.password("test")
			.build();
