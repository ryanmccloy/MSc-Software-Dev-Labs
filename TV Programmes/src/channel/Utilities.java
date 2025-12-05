/**
 * 
 */
package channel;

import java.util.List;

/**
 * Utility methods for the TVGuide class
 */
public class Utilities {


	/**
	 * method displays all details for each show
	 * @param shows
	 */
	public static void displayAllProgrammes(List<Programme> shows) {
		
		System.out.println(TVGuide.BOLD_TEXT + "ALL PROGRAMMES" + TVGuide.RESET_TEXT);
		System.out.println();
		
		for (Programme programme : shows) {
			programme.displayAll();
		}
		
	}

	
}
