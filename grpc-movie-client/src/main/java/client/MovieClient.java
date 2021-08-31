package client;

import com.thinkbycode.movie.stub.MovieRequest;
import com.thinkbycode.movie.stub.MovieServiceGrpc;
import com.thinkbycode.movie.stub.MovieServiceGrpc.MovieServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class MovieClient {
	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		
		MovieServiceBlockingStub syncClient = MovieServiceGrpc.newBlockingStub(channel);
		
		simpleUnaryCall(syncClient);
		
		simpleUnaryWithException(syncClient);
	}

	private static void simpleUnaryWithException(MovieServiceBlockingStub syncClient) {
		System.out.println("=======Simple Unary Call with Exception==========");
		try {
			syncClient.getMovie(MovieRequest.newBuilder().setTitle("lotr").build())
			.getMovieList()
			.forEach(System.out::println);
		} catch(StatusRuntimeException e) {
			System.out.println("Caught server exception");
			e.printStackTrace();
		}
	}

	private static void simpleUnaryCall(MovieServiceBlockingStub syncClient) {
		System.out.println("=======Simple Unary Call==========");
		syncClient.getMovie(MovieRequest.newBuilder().setTitle("LOTR").build())
				.getMovieList()
				.forEach(System.out::println);
	}

}
