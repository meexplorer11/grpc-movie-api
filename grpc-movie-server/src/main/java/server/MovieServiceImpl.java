package server;

import java.util.Optional;

import com.thinkbycode.movie.stub.Movie;
import com.thinkbycode.movie.stub.MovieRequest;
import com.thinkbycode.movie.stub.MovieResponse;
import com.thinkbycode.movie.stub.MovieServiceGrpc.MovieServiceImplBase;

import dao.MovieDAO;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class MovieServiceImpl extends MovieServiceImplBase {
	private MovieDAO dao;
	
	public MovieServiceImpl() {
		dao = new MovieDAO();
	}
	
	@Override
	public void getMovie(MovieRequest request, StreamObserver<MovieResponse> responseObserver) {
		Optional<Movie> movie = dao.byTitle(request.getTitle());
		
		if(movie.isPresent()) {
			responseObserver.onNext(MovieResponse.newBuilder().addMovie(movie.get()).build());
			responseObserver.onCompleted();
		} else {
			responseObserver.onError(Status.NOT_FOUND.withDescription("No movie found!!").asRuntimeException());
		}
	}
	
}
