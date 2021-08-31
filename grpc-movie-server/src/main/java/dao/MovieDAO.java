package dao;

import java.util.Map;
import java.util.Optional;

import com.thinkbycode.movie.stub.Movie;

import db.MovieRepository;

public class MovieDAO {
	private MovieRepository repo;
	
	public MovieDAO() {
		repo = new MovieRepository();
	}
	
	public Map<Integer, Movie> getAllMovies() {
		return repo.getAllMovies();
	}
	
	public Optional<Movie> byTitle(String title) {
		return repo.getAllMovies().values().stream().filter(m -> m.getTitle().equals(title)).findFirst();
	}
}
