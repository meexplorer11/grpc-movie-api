package db;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thinkbycode.movie.stub.Movie;

public class MovieRepository {
	private static Map<Integer, Movie> MOVIES = new HashMap<>();
	
	static {
		MOVIES.put(1, toMovie("LOTR", "Peter", 9.9, Arrays.asList("Virgo", "Ian", "Elijah")));
		MOVIES.put(2, toMovie("The Dark Knight", "Nolan", 9.9, Arrays.asList("Christian", "Heath", "Gary")));
		MOVIES.put(3, toMovie("Matrix", "Lana", 9.9, Arrays.asList("Keanu", "Carrie", "Hugo")));
	}
	
	public Map<Integer, Movie> getAllMovies() {
		return MOVIES;
	}

	private static Movie toMovie(String title, String director, double rating, List<String> actors) {
		return Movie.newBuilder()
				.setTitle(title)
				.setDirector(director)
				.setRating(rating)
				.addAllActors(actors)
				.build();
	}
	
	
}
