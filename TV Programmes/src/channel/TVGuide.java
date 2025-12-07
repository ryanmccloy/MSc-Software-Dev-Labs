/**
 * 
 */
package channel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * start point of application. Class reads TV shows from a CSV file and stores
 * them in a Programme instance. A menu is displayed to allow users to view all
 * programmes, or search by various parameters
 * 
 */
public class TVGuide {

	/**
	 * Constants for text formatting
	 */
	final static String RED_TEXT = "\033[0;31m";
	final static String GREEN_TEXT = "\033[0;32m";
	final static String BOLD_TEXT = "\033[1m";
	final static String RESET_TEXT = "\033[0m";

	// ArrayList to store programmes
	public static List<Programme> shows = new ArrayList<Programme>();

	/**
	 * @param args 
	 */
	public static void main(String[] args) {

		System.out.println("TV CHANNEL APP STARTED");
		System.out.println("----------------------");
		System.out.println();

		try {
			readCSVFile("TVProgrammes.csv");
			showMenu();

		} catch (Exception e) {
			System.err.println("Sorry there has been a problem! Please contact admin");
			System.err.println(e.getMessage());
		}

		System.out.println();
		System.out.println("---------------------");
		System.out.println("TV CHANNEL APP CLOSED");

	}

	/**
	 * method reads from given CSV file and stores Programmes in the shows ArrayList
	 * 
	 * @param string
	 */
	private static void readCSVFile(String path) {

		File file = new File(path);
		String data;

		System.out.println("Reading programmes...");

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {

			// clear heading
			br.readLine();

			// loop over each line of the CSV
			while ((data = br.readLine()) != null) {

				Programme programme = new Programme();

				// get each data part of programme
				String[] dataParts = data.split(",");

				// programme name
				programme.setName(dataParts[0]);

				// broadcaster
				switch (dataParts[1]) {
				case "BBC":
					programme.setBroadcaster(Broadcaster.BBC);
					break;
				case "ITV":
					programme.setBroadcaster(Broadcaster.ITV);
					break;
				case "Channel 4":
					programme.setBroadcaster(Broadcaster.CHANNEL_4);
					break;
				case "Netflix":
					programme.setBroadcaster(Broadcaster.NETFLIX);
					break;
				case "Amazon Prime":
					programme.setBroadcaster(Broadcaster.AMAZON_PRIME);
					break;
				case "Apple TV":
					programme.setBroadcaster(Broadcaster.APPLE_TV);
					break;
				case "HBO":
					programme.setBroadcaster(Broadcaster.HBO);
					break;
				default:
					System.err.println("Invalid broadcaster. Skipping programme...");
					continue;
				}

				// rating
				try {
					programme.setRating(Integer.parseInt(dataParts[2]));
				} catch (NumberFormatException e) {
					System.err.println("Invalid rating. Defaulting to 0");
				} catch (IllegalArgumentException e) {
					System.err.println("Invalid rating. Defaulting to 0");
				}

				// average audience
				try {
					programme.setAverageAudience(Double.parseDouble(dataParts[3]));
				} catch (NumberFormatException e) {
					System.err.println("Invalid average audience. Defaulting to 0");
				}

				// adding programme object to the ArrayList shows
				shows.add(programme);

			}

		} catch (IOException e) {
			System.err.println("Problem reading file : " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Problem reading file : " + e.getMessage());
		}

		// statistics
		System.out.println("Read complete! Programmes processed : " + GREEN_TEXT + shows.size() + RESET_TEXT);
		System.out.println();

	}

	/**
	 * method displays the user menu until user chooses to quit application
	 */
	private static void showMenu() {

		Scanner sc = new Scanner(System.in);
		int choice;

		do {

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(GREEN_TEXT);
			System.out.println("1. Display all programmes");
			System.out.println("2. Search by programme title");
			System.out.println("3. Search by broadcaster");
			System.out.println("4. Search by rating (greater than or equal to)");
			System.out.println("5. Search by rating (less than or equal to)");
			System.out.println("6. Rating (high to low)");
			System.out.println("7. Rating (low to high)");
			System.out.println("8. Average Audience (high to low)");
			System.out.println("9. Average audience (low to high)");
			System.out.println("0. Quit");
			System.out.println(RESET_TEXT);

			while (!sc.hasNextInt()) {
				System.err.println("Please enter a number:");
				sc.nextLine(); // clear invalid input
				System.out.println();
			}

			choice = sc.nextInt();
			sc.nextLine(); // clear rest of line
			System.out.println();

			switch (choice) {
			case 1:
				Utilities.displayAllProgrammes(shows);
				break;
			case 2:
				System.out.println("Please enter the title you wish to search for:");
				String title = sc.nextLine();
				System.out.println();
				List<Programme> resultsTitle = Utilities.searchProgrammesByTitle(title, shows);

				if (resultsTitle.size() != 0) {
					System.out.println(
							TVGuide.BOLD_TEXT + "ALL " + title.toUpperCase() + " DETAILS" + TVGuide.RESET_TEXT);
					System.out.println();

					for (Programme programme : resultsTitle) {
						programme.displayAll();
					}
				} else {
					System.err.println("Sorry! No programmes available called '" + title + "'");
				}

				break;

			case 3:
				System.out.println("Please enter the broadcaster you wish to search for:");
				String broadcaster = sc.nextLine();
				System.out.println();
				List<Programme> resultsBroadcaster = Utilities.searchProgrammesByBroadcaster(broadcaster, shows);

				if (resultsBroadcaster.size() != 0) {
					System.out.println(
							TVGuide.BOLD_TEXT + "ALL PROGRAMMES BY " + broadcaster.toUpperCase() + TVGuide.RESET_TEXT);
					System.out.println();

					for (Programme programme : resultsBroadcaster) {
						programme.displayAll();
					}
				} else {
					System.err.println("Sorry! No programmes available by '" + broadcaster + "'");
				}

				break;
			case 4:
				System.out.println("Please enter the rating (0-10) you wish to search for (>=):");

				while (!sc.hasNextInt()) {
					System.err.println("Please enter a number:");
					sc.nextLine(); // clear invalid input
					System.out.println();
				}

				int ratingUpper = sc.nextInt();
				sc.nextLine(); // clear line
				System.out.println();

				List<Programme> resultsRatingUpper = Utilities.searchProgrammesByRatingUpper(ratingUpper, shows);

				if (resultsRatingUpper.size() != 0) {
					System.out.println(TVGuide.BOLD_TEXT + "ALL PROGRAMMES WITH A RATING GREATER OR EQUAL TO "
							+ ratingUpper + TVGuide.RESET_TEXT);
					System.out.println();

					for (Programme programme : resultsRatingUpper) {
						programme.displayAll();
					}
				} else {
					System.err.println("Sorry! No programmes with a rating of " + ratingUpper + " or higher :(");
				}
				break;
			case 5:
				System.out.println("Please enter the rating (0-10) you wish to search for (<=):");

				while (!sc.hasNextInt()) {
					System.err.println("Please enter a number:");
					sc.nextLine(); // clear invalid input
					System.out.println();
				}

				int ratingLower = sc.nextInt();
				sc.nextLine(); // clear line
				System.out.println();

				List<Programme> resultsRatingLower = Utilities.searchProgrammesByRatingLower(ratingLower, shows);

				if (resultsRatingLower.size() != 0) {
					System.out.println(TVGuide.BOLD_TEXT + "ALL PROGRAMMES WITH A RATING LESS THAN OR EQUAL TO "
							+ ratingLower + TVGuide.RESET_TEXT);
					System.out.println();

					for (Programme programme : resultsRatingLower) {
						programme.displayAll();
					}
				} else {
					System.err.println("Sorry! No programmes with a rating of " + ratingLower + " or less :)");
				}
				break;
			case 6:
				List<Programme> showsRatingHighToLow = Utilities.sortShowsByRatingHighToLow(shows);

				System.out.println(TVGuide.BOLD_TEXT + "RATING - HIGH TO LOW" + TVGuide.RESET_TEXT);
				System.out.println();

				for (Programme programme : showsRatingHighToLow) {
					programme.displayAll();
				}
				break;
			case 7:
				List<Programme> showsRatingLowToHigh = Utilities.sortShowsByRatingLowToHigh(shows);

				System.out.println(TVGuide.BOLD_TEXT + "RATING - LOW TO HIGH" + TVGuide.RESET_TEXT);
				System.out.println();

				for (Programme programme : showsRatingLowToHigh) {
					programme.displayAll();
				}
				break;
			case 8: 
				List<Programme> showsAverageAudienceHighToLow = Utilities.sortShowsByAverageAudienceHighToLow(shows);

				System.out.println(TVGuide.BOLD_TEXT + "AVERAGE AUDIENCE - HIGH TO LOW" + TVGuide.RESET_TEXT);
				System.out.println();

				for (Programme programme : showsAverageAudienceHighToLow) {
					programme.displayAll();
				}
				break;
			case 9: 
				List<Programme> showsAverageAudienceLowToHigh = Utilities.sortShowsByAverageAudienceLowToHigh(shows);

				System.out.println(TVGuide.BOLD_TEXT + "AVERAGE AUDIENCE - LOW TO HIGH" + TVGuide.RESET_TEXT);
				System.out.println();

				for (Programme programme : showsAverageAudienceLowToHigh) {
					programme.displayAll();
				}
				break;
			case 0:
				choice = 0;
				System.out.println("See you next time!");
				break;
			default:
				System.err.println("Invalid choice. Please try again...");
			}

		} while (choice != 0);

	}

}
