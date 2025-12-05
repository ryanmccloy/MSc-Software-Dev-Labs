/**
 * 
 */
package music;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class UtilitiesTest {

	// test data
	List<Song> songs;
	List<Song> results;
	Song song1, song2, song3, song4, song5;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		songs = new ArrayList<Song>();
		results = new ArrayList<Song>();

		song1 = new Song("Nutshell", "Alice In Chains", 1);
		song2 = new Song("Would", "Alice In Chains", 2);
		song3 = new Song("Even Flow", "Pearl Jam", 3);
		song4 = new Song("Thriller", "Michael Jackson", 4);
		song5 = new Song("One", "Metallica", 5);

		songs.add(song1);
		songs.add(song2);
		songs.add(song3);
		songs.add(song4);
		songs.add(song5);
	}

	/**
	 * Test method for {@link music.Utilities#searchByArtist(java.lang.String)}.
	 */
	@Test
	void testSearchByArtist() {
		results = Utilities.searchByArtist("Alice In Chains", songs);

		assertEquals(2, results.size());
		assertTrue(results.contains(song1));
		assertTrue(results.contains(song2));

	}

	/** 
	 * Test method for {@link music.Utilities#searchByTitle(java.lang.String)}.
	 */ 
	@Test
	void testSearchByTitle() { 
		results = Utilities.searchByTitle("Nutshell", songs);
		assertEquals(1, results.size());
;		assertTrue(results.contains(song1));

		results = Utilities.searchByTitle("Would", songs);
		assertTrue(results.contains(song2));

		results = Utilities.searchByTitle("Even Flow", songs);
		assertTrue(results.contains(song3));

		results = Utilities.searchByTitle("Thriller", songs);
		assertTrue(results.contains(song4));

		results = Utilities.searchByTitle("One", songs);
		assertTrue(results.contains(song5));

	}

}
