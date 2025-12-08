/**
 * 
 */
package christmas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class simulates a Netflix Christmas movie list
 */
public class NetflixYuleTime {

	/**
	 * Constants for text formatting
	 */
	final static String RED_TEXT = "\033[0;31m";
	final static String GREEN_TEXT = "\033[0;32m";
	final static String BOLD_TEXT = "\033[1m";
	final static String RESET_TEXT = "\033[0m";

	// ArrayList for storing movie instances
	public static List<Movie> movies = new ArrayList<Movie>();

	/**
	 * start point of application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("CHRISTMAS MOVIES");
		System.out.println("----------------");
		System.out.println();

		try {
			importMovies("christmas_movies.csv");
			showMenu();

		} catch (Exception e) {
			System.err.println("Sorry there has been a problem! Please contact the admin...");
		}

		System.out.println();
		System.out.println("--------------");
		System.out.println("NETFLIX CLOSED");

	}

	/**
	 * method reads movies from a given CSV file, and stores them in the movies
	 * ArrayList
	 * 
	 * @param path
	 */
	private static void importMovies(String path) {

		File file = new File(path);
		String data;

		System.out.println("Reading movies...");

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {

			br.readLine(); // skip heading

			// loop each line of CSV to store the data in a Movie instance and then in the
			// movies ArrayList
			while ((data = br.readLine()) != null) {

				Movie movie = new Movie();
				String[] movieDetails = data.split(",");

				// movieID
				try {
					movie.setMovieID(Integer.parseInt(movieDetails[0]));
				} catch (NumberFormatException e) {
					System.err.println("Invalid movieID - defaulting to 0");
					movie.setMovieID(0); // default
				}

				// title
				if (movieDetails[1].isEmpty() || movieDetails[1] == null) {
					System.err.println("No movie name provided. Skipping movie...");
					continue;
				} else {
					movie.setTitle(movieDetails[1]);
				}

				// year
				try {
					movie.setYear(Integer.parseInt(movieDetails[2]));
				} catch (NumberFormatException e) {
					System.err.println("Invalid movie year. Defaulting to 2000");
					movie.setYear(2000);
				}

				// rating
				switch (movieDetails[3]) {
				case "PG":
					movie.setRating(Rating.PG);
					break;
				case "G":
					movie.setRating(Rating.G);
					break;
				case "U":
					movie.setRating(Rating.U);
					break;
				case "PG-13":
					movie.setRating(Rating.PG_THIRTEEN);
					break;
				case "12":
					movie.setRating(Rating.TWELVE);
					break;
				case "15":
					movie.setRating(Rating.FIFTEEN);
					break;
				default:
					System.err.println("Invalid rating. Defaulting to 'Error'");
					movie.setRating(Rating.ERROR);
				}

				// genre
				switch (movieDetails[4]) {
				case "Comedy":
					movie.setGenre(Genre.COMEDY);
					break;
				case "Family":
					movie.setGenre(Genre.FAMILY);
					break;
				case "Animation":
					movie.setGenre(Genre.ANIMATION);
					break;
				case "Fantasy":
					movie.setGenre(Genre.FANTASY);
					break;
				case "Romance":
					movie.setGenre(Genre.ROMANCE);
					break;
				case "Drama":
					movie.setGenre(Genre.DRAMA);
					break;
				case "Musical":
					movie.setGenre(Genre.MUSICAL);
					break;
				case "War":
					movie.setGenre(Genre.WAR);
					break;
				default:
					System.err.println("Invalid genre. Defaulting to 'Error'");
					movie.setGenre(Genre.ERROR);
				}

				// familyFriendly
				try {
					movie.setFamilyFriendly(Boolean.parseBoolean(movieDetails[5]));
				} catch (Exception e) {
					System.err.println("Invalid reading for familyFriendly. Defaulting to false");
					movie.setFamilyFriendly(false);
				}

				// store movie in ArrayList
				movies.add(movie);

			}

		} catch (FileNotFoundException e) {
			System.err.println("File not found. Cannot import movies : " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem reading from file : " + e.getMessage());
		}

		// statistics
		System.out.println("Movie import complete. Movies processed : " + movies.size());
		System.out.println();

	}

	/**
	 * method shows the user menu to the console, until the user chooses to quit
	 */
	private static void showMenu() {
		Scanner sc = new Scanner(System.in);
		int choice;

		do {

			try {
				Thread.sleep(2000); // small delay to allow user time to see output
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// menu
			System.out.println(GREEN_TEXT);
			System.out.println("1. Show all movies");
			System.out.println("2. Search title");
			System.out.println("3. Search by rating");
			System.out.println("4. Search by genre");
			System.out.println("5. Search by family friendly");
			System.out.println("0. Quit");
			System.out.println("");
			System.out.println("----------------------------" + RESET_TEXT);

			while (!sc.hasNextInt()) {
				System.out.println("Please enter a number:");
				sc.nextLine(); // clear invalid line
				System.out.println();
			}

			choice = sc.nextInt();
			sc.nextLine(); // clear rest of line
			System.out.println();

			// process user choice
			switch (choice) {
			case 1:
				System.out.println(BOLD_TEXT + "ALL MOVIE DETAILS" + RESET_TEXT);
				System.out.println();
				Utilities.displayAllMovieDetails(movies);
				break;
			case 2:
				System.out.println("Please enter the title you want to search for:");
				System.out.println();
				String title = sc.nextLine().trim();
				System.out.println();
				List<Movie> resultsTitle = Utilities.searchMoviesByTitle(title, movies);

				if (resultsTitle.size() != 0) {
					System.out
							.println(BOLD_TEXT + "MOVIE TITLES CONTAINING '" + title.toUpperCase() + "'" + RESET_TEXT);
					System.out.println();

					for (Movie movie : resultsTitle) {
						movie.displayAll();

					}
				} else {
					System.out.println("Sorry, no movie contains '" + title.toUpperCase() + "' in the title...");
					System.out.println();
				}

				break;
			case 3:
				System.out.println("Which rating do you want to search by: ");
				System.out.println("1. U");
				System.out.println("2. G");
				System.out.println("3. PG-13");
				System.out.println("4. 12");
				System.out.println("5. 15");
				System.out.println();

				while (!sc.hasNextInt()) {
					System.out.println("Please enter a number:");
					sc.nextLine(); // clear invalid line
					System.out.println();
				}

				int ratingChoice = sc.nextInt();
				sc.nextLine(); // clear rest of line
				System.out.println();
				
				Rating rating;

				switch (ratingChoice) {
				case 1:
					rating = Rating.U;
					break;
				case 2:
					rating = Rating.G;
					break;
				case 3:
					rating = Rating.PG_THIRTEEN;
					break;
				case 4:
					rating = Rating.TWELVE;
					break;
				case 5:
					rating = Rating.FIFTEEN;
					break;
				default:
					System.out.println("Invalid option...");
					continue;
				}

				List<Movie> moviesByRating = Utilities.searchMovieByRating(rating, movies);

				if (moviesByRating.size() != 0) {
					System.out.println(BOLD_TEXT + "MOVIES RATED '" + rating.getDescription().toUpperCase() + "'"
							+ RESET_TEXT);
					System.out.println();

					for (Movie movie : moviesByRating) {
						movie.displayAll();

					}
				} else {
					System.out.println("Sorry, no movie rated '" + rating.getDescription().toUpperCase() + "'");
					System.out.println();
				}
				break;
			case 4:
				System.out.println("Which genre do you want to search by: ");
				System.out.println("1. Comedy");
				System.out.println("2. Family");
				System.out.println("3. Animation");
				System.out.println("4. Fantasy");
				System.out.println("5. Romance");
				System.out.println("6. Drama");
				System.out.println("7. War");
				System.out.println();


				while (!sc.hasNextInt()) {
					System.out.println("Please enter a number:");
					sc.nextLine(); // clear invalid line
					System.out.println();
				}

				int genreChoice = sc.nextInt();
				sc.nextLine(); // clear rest of line
				System.out.println();
				
				Genre genre;

				switch (genreChoice) {
				case 1:
					genre = Genre.COMEDY;
					break;
				case 2:
					genre = Genre.FAMILY;
					break;
				case 3:
					genre = Genre.ANIMATION;
					break;
				case 4:
					genre = Genre.FANTASY;
					break;
				case 5:
					genre = Genre.ROMANCE;
					break;
				case 6:
					genre = Genre.DRAMA;
					break;
				case 7:
					genre = Genre.WAR;
					break;
				default:
					System.out.println("Invalid option...");
					continue; 
				}

				List<Movie> moviesByGenre = Utilities.searchMovieByGenre(genre, movies);

				if (moviesByGenre.size() != 0) {
					System.out.println(BOLD_TEXT + "ALL '" + genre.getDescription().toUpperCase() + "' MOVIES"
							+ RESET_TEXT);
					System.out.println();

					for (Movie movie : moviesByGenre) {
						movie.displayAll();

					}
				} else {
					System.out.println("Sorry, no '" + genre.getDescription().toUpperCase() + "' movies...");
					System.out.println();
				}
				break;
			case 5: 
				List<Movie> moviesByFamilyFriendly = Utilities.searchByFamilyFriendly(movies);
				
				if (moviesByFamilyFriendly.size() != 0) {
					System.out.println(BOLD_TEXT + "ALL FAMILY FRIENDLY MOVIES"
							+ RESET_TEXT);
					System.out.println();

					for (Movie movie : moviesByFamilyFriendly) {
						movie.displayAll();

					}
				} else {
					System.out.println("Sorry, no family friendly movies...");
					System.out.println();
				}
				break;
			case 0:
				System.out.println("Thanks for watching. Merry Christmas!");
				choice = 0;
				break;
			default:
				System.err.println("Invalid choice. Please try again...");
			}

		} while (choice != 0);

	}

}
