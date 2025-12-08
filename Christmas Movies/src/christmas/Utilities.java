/**
 * 
 */
package christmas;

import java.util.ArrayList;
import java.util.List;

/**
 * utility methods for the NetflixYuleTime class
 */
public class Utilities {

	/**
	 * method displays all movie details to the console, for each movie in the given
	 * List
	 * 
	 * @param movies
	 */
	public static void displayAllMovieDetails(List<Movie> movies) {

		for (Movie movie : movies) {
			movie.displayAll();
		}

	}

	/**
	 * method searches the given List and returns the matching title
	 * 
	 * @param title
	 * @param movies
	 * @return
	 */
	public static List<Movie> searchMoviesByTitle(String title, List<Movie> movies) {

		List<Movie> results = new ArrayList<Movie>();

		for (Movie movie : movies) {
			if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
				results.add(movie);
			}
		}

		return results;
	}

	/**
	 * method searches and returns the movies which match the given rating
	 * 
	 * @param ratingChoice
	 * @param movies
	 * @return
	 */
	public static List<Movie> searchMovieByRating(Rating rating, List<Movie> movies) {

		List<Movie> results = new ArrayList<Movie>();

		for (Movie movie : movies) {
			if (movie.getRating().equals(rating)) {
				results.add(movie);
			}
		}

		return results;
	}

	/**
	 * method searches and returns the movies which match the given genre
	 * 
	 * @param genre
	 * @param movies
	 * @return
	 */
	public static List<Movie> searchMovieByGenre(Genre genre, List<Movie> movies) {

		List<Movie> results = new ArrayList<Movie>();

		for (Movie movie : movies) {
			if (movie.getGenre().equals(genre)) {
				results.add(movie);
			}
		}

		return results;
	}

	/**
	 * method searches and returns the movies which are family friendly
	 */
	public static List<Movie> searchByFamilyFriendly(List<Movie> movies) {
		
		List<Movie> results = new ArrayList<Movie>();

		for (Movie movie : movies) {
			if (movie.isFamilyFriendly()) {
				results.add(movie);
			}
		}

		return results;
	}

}
