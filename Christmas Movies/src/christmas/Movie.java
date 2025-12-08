/**
 * 
 */
package christmas;

/**
 * represents a single movie in the system
 */
public class Movie {
	
	private int movieID;
	private String title;
	private int year;
	private Rating rating;
	private Genre genre;
	boolean familyFriendly;

	/**
	 * Default constructor
	 */
	public Movie() {
		
	}

	/**
	 * constructor with arguments
	 * 
	 * @param movieID
	 * @param title
	 * @param year
	 * @param rating
	 * @param genre
	 * @param familyFriendly
	 */
	public Movie(int movieID, String title, int year, Rating rating, Genre genre, boolean familyFriendly) {
		super();
		this.movieID = movieID;
		this.title = title;
		this.year = year;
		this.rating = rating; 
		this.genre = genre;
		this.familyFriendly = familyFriendly;
	}

	/**
	 * @return the movieID
	 */
	public int getMovieID() {
		return movieID;
	}

	/**
	 * @param movieID the movieID to set
	 */
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the rating
	 */
	public Rating getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Rating rating) {
		this.rating = rating;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	/**
	 * @return the familyFriendly
	 */
	public boolean isFamilyFriendly() {
		return familyFriendly;
	}

	/**
	 * @param familyFriendly the familyFriendly to set
	 */
	public void setFamilyFriendly(boolean familyFriendly) {
		this.familyFriendly = familyFriendly;
	}
	 
	/**
	 * display all movie details in a clear, formatted layout
	 */
	public void displayAll() {
		System.out.println("Movie ID\t:  " + this.movieID);
		System.out.println("Title\t\t:  " + this.title.toUpperCase());
		System.out.println("Year\t\t:  " + this.year);
		System.out.println("Rating\t\t:  " + this.rating.getDescription());
		System.out.println("Genre\t\t:  " + this.genre.getDescription());
		System.out.println("Family Friendly\t:  " + (this.familyFriendly ? "True" : "False"));
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println();
	}

	
}
