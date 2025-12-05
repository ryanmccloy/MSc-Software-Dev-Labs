/**
 * 
 */
package music;

import java.util.ArrayList;
import java.util.List;

/**
 * utility methods for song searching
 */
public class Utilities {

	/**
	 * method searches all songs and returns an ArrayList containing songs from a
	 * given artist
	 * 
	 * @param artist
	 * @return
	 */ 
	public static List<Song> searchByArtist(String artist, List<Song> songs) {
		List<Song> results = new ArrayList<Song>();

		for (Song song : songs) {
			if (song.getArtist().equalsIgnoreCase(artist)) {
				results.add(song);
			}
		}
 
		return results;
	}
	
	/**
	 * method searches all songs and returns an ArrayList containing songs from a
	 * given title
	 * 
	 * @param title
	 * @return
	 */
	public static List<Song> searchByTitle(String title, List<Song> songs) {
		List<Song> results = new ArrayList<Song>();

		for (Song song : songs) {
			if (song.getTitle().equalsIgnoreCase(title)) {
				results.add(song);
			}
		}

		return results;
	}
	
}
