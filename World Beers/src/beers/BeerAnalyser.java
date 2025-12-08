/**
 * 
 */
package beers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class BeerAnalyser {

	/**
	 * Constants for text formatting
	 */
	final static String RED_TEXT = "\033[0;31m";
	final static String GREEN_TEXT = "\033[0;32m";
	final static String BOLD_TEXT = "\033[1m";
	final static String RESET_TEXT = "\033[0m";

	/**
	 * Beers file path
	 */
	final static String BEERS_FILE_PATH = "beer_data.csv";

	// Beer ArrayList to store beers from the CSV
	public static List<Beer> beers = new ArrayList<Beer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("BEER ANALYSER STARTED");
		System.out.println("---------------------");
		System.out.println();

		try {
			readBeersFromCSV(BEERS_FILE_PATH);
			showMenu();
		} catch (Exception e) {
			System.err.println("Sorry there has been an error! Please contact the admin");
		}

		System.out.println();
		System.out.println("--------------------");
		System.out.println("BEER ANALYSER CLOSED");

	}

	/**
	 * method reads beers from the given file path, and stores the data as an
	 * instance of the Beer object. All instances are then stored in the beers
	 * ArrayList
	 * 
	 * Data provided by the CSV - Beer Name,Beer Style,Country,Alcohol Percentage
	 * 
	 * @param beersFilePath
	 */
	private static void readBeersFromCSV(String beersFilePath) {

		File file = new File(beersFilePath);
		String data;

		System.out.println("Processing beers started...");

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {

			br.readLine(); // skip heading

			while ((data = br.readLine()) != null) {

				Beer beer = new Beer();
				String[] beerDetails = data.split(",");

				// name
				beer.setName(beerDetails[0]);

				// style
				beer.setStyle(beerDetails[1]);

				// country
				beer.setCountry(beerDetails[2]);

				// strength
				try {
					beer.setStrength(Double.parseDouble(beerDetails[3]));
				} catch (NumberFormatException e) {
					System.err.println("Problem reading beer strength. Defaulting to 5%");
					beer.setStrength(5); // default
				}

				// add beer to beers ArrayList
				beers.add(beer);

			}

		} catch (FileNotFoundException e) {
			System.err.println("File not found : " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem reading from file : " + e.getMessage());
		}

		// statistics
		System.out.println("Beers processing complete. Total number of beers: " + beers.size());
		System.out.println();

	}

	/**
	 * displays the menu to the console. Allows user to see all beer details, order
	 * the beers by name, output all beers above 6% strength to a new file
	 */
	private static void showMenu() {

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			
			// simulate small delay to allow user time to see output
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(GREEN_TEXT + "Please select an option:");
			System.out.println("1. Show all beers");
			System.out.println("2. Order beers by name");
			System.out.println("3. Order beers by strength");
			System.out.println("4. Output to file all beers over 6% alcohol");
			System.out.println("5. Add a beer");
			System.out.println("6. Delete a beer");
			System.out.println("0. Quit");
			System.out.println(RESET_TEXT);
			
			
			while (!sc.hasNextInt()) {
				System.out.println("Please enter a valid option:");
				sc.nextLine(); // clear invalid line
				System.out.println();
			}
			
			choice = sc.nextInt();
			sc.nextLine(); // clear rest of line
			System.out.println();
			
			
			switch(choice) {
			case 1: Utilities.displayAllBeerDetails(beers); break;
			case 2: Utilities.orderBeersByName(beers); break;
			case 3: Utilities.orderBeersByStrength(beers); break;
			case 4: Utilities.outputBeerByStrength(beers); break;
			case 5: Utilities.addBeer(beers, sc); break;
			case 6:
				String name;
				System.out.println("Please enter the name of the beer you want to delete:");
				name = sc.nextLine();
				System.out.println();
				Utilities.deleteBeer(name, beers);
				break;
			case 0: choice = 0;
			System.out.println("Drink responsibly! See you next time :)");
			break;
			default: System.out.println("Invalid option. Please try again...");
			}
			
		} while (choice != 0);
		
		sc.close();

	}

}
