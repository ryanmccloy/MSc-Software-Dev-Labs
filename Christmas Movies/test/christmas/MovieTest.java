/**
 * 
 */
package christmas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit testing class for the Movie object
 */
class MovieTest {

	// test data
	Movie movie;
	int movieIDValid;
	String movieTitleValid;
	int yearValid;
	Rating ratingValid1, ratingValid2, ratingValid3, ratingValid4, ratingValid5, ratingValid6;
	Genre genreValid1, genreValid2, genreValid3, genreValid4, genreValid5, genreValid6, genreValid7, genreValid8;
	boolean familyFriendlyTrue, familyFriendlyFalse;

	/** 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		movie = new Movie();

		movieIDValid = 1234567;

		movieTitleValid = "A Movie Title";

		yearValid = 1993;

		// PG("PG"), G("G"), U("U"), PG_THIRTEEN("PG-13"), TWELVE("12"), FIFTEEN("15");
		ratingValid1 = Rating.PG;
		ratingValid2 = Rating.G;
		ratingValid3 = Rating.U;
		ratingValid4 = Rating.PG_THIRTEEN;
		ratingValid5 = Rating.TWELVE;
		ratingValid6 = Rating.FIFTEEN;

		// COMEDY("Comedy"), FAMILY("Family"), ANIMATION("Animation"),
		// FANTASY("Fantasy"), ROMANCE("Romance"), DRAMA("Drama"), MUSICAL("Musical"),
		// WAR("War");
		genreValid1 = Genre.COMEDY;
		genreValid2 = Genre.FAMILY;
		genreValid3 = Genre.ANIMATION;
		genreValid4 = Genre.FANTASY;
		genreValid5 = Genre.ROMANCE;
		genreValid6 = Genre.DRAMA;
		genreValid7 = Genre.MUSICAL;
		genreValid8 = Genre.WAR;

		familyFriendlyTrue = true;
		familyFriendlyFalse = false;

	}

	/**
	 * Test method for {@link christmas.Movie#Movie()}.
	 */
	@Test
	void testMovieDefaultConstructor() {
		assertNotNull(movie);
	}

	/**
	 * Test method for
	 * {@link christmas.Movie#Movie(int, java.lang.String, int, christmas.Rating, christmas.Genre, boolean)}.
	 */
	@Test
	void testMovieConstructorWithArgumentsValid() {
		movie = new Movie(movieIDValid, movieTitleValid, yearValid, ratingValid1, genreValid1, familyFriendlyTrue);

		assertEquals(movieIDValid, movie.getMovieID());
		assertEquals(movieTitleValid, movie.getTitle());
		assertEquals(yearValid, movie.getYear());
		assertEquals(ratingValid1, movie.getRating());
		assertEquals(genreValid1, movie.getGenre());
		assertEquals(familyFriendlyTrue, movie.isFamilyFriendly());
	}

	/**
	 * Test method for {@link christmas.Movie#getMovieID()}.
	 */
	@Test
	void testGetSetMovieIDValid() {

		movie.setMovieID(movieIDValid);
		assertEquals(movieIDValid, movie.getMovieID());

	}

	/**
	 * Test method for {@link christmas.Movie#getTitle()}.
	 */
	@Test
	void testGetSetTitleValid() {

		movie.setTitle(movieTitleValid);
		assertEquals(movieTitleValid, movie.getTitle());
	}

	/**
	 * Test method for {@link christmas.Movie#getYear()}.
	 */
	@Test
	void testGetSetYearValid() {

		movie.setYear(yearValid);
		assertEquals(yearValid, movie.getYear());

	}

	/**
	 * Test method for {@link christmas.Movie#getRating()}.
	 */
	@Test
	void testGetSetRatingValid() {

		movie.setRating(ratingValid1);
		assertEquals(ratingValid1, movie.getRating());

		movie.setRating(ratingValid2);
		assertEquals(ratingValid2, movie.getRating());

		movie.setRating(ratingValid3);
		assertEquals(ratingValid3, movie.getRating());

		movie.setRating(ratingValid4);
		assertEquals(ratingValid4, movie.getRating());

		movie.setRating(ratingValid5);
		assertEquals(ratingValid5, movie.getRating());

		movie.setRating(ratingValid6);
		assertEquals(ratingValid6, movie.getRating());

	}

	/**
	 * Test method for {@link christmas.Movie#getGenre()}.
	 */
	@Test
	void testGetSetGenreValid() {

		movie.setGenre(genreValid1);
		assertEquals(genreValid1, movie.getGenre());

		movie.setGenre(genreValid2);
		assertEquals(genreValid2, movie.getGenre());

		movie.setGenre(genreValid3);
		assertEquals(genreValid3, movie.getGenre());

		movie.setGenre(genreValid4);
		assertEquals(genreValid4, movie.getGenre());

		movie.setGenre(genreValid5);
		assertEquals(genreValid5, movie.getGenre());

		movie.setGenre(genreValid6);
		assertEquals(genreValid6, movie.getGenre());

		movie.setGenre(genreValid7);
		assertEquals(genreValid7, movie.getGenre());

		movie.setGenre(genreValid8);
		assertEquals(genreValid8, movie.getGenre());

	}

	/**
	 * Test method for {@link christmas.Movie#isFamilyFriendly()}.
	 */
	@Test
	void testIsFamilyFriendlyValid() {
		
		movie.setFamilyFriendly(familyFriendlyTrue);
		assertTrue(movie.isFamilyFriendly());
		
		movie.setFamilyFriendly(familyFriendlyFalse);
		assertFalse(movie.isFamilyFriendly());
		
	}

}
