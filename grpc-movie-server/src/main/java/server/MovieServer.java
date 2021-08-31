package server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class MovieServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(50051).addService(new MovieServiceImpl()).build();
		server.start();
		System.out.println("Server started...");
		
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Received shutdown request");
			server.shutdown();
		}));
		
		server.awaitTermination();
	}

}
