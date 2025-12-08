/**
 * 
 */
package beers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Utility methods for the BeerAnalyser app
 */
public class Utilities {

	/**
	 * method displays all beer details to the console
	 * 
	 * @param beers
	 */
	public static void displayAllBeerDetails(List<Beer> beers) {

		System.out.println(BeerAnalyser.BOLD_TEXT + "ALL BEER DETAILS" + BeerAnalyser.RESET_TEXT);
		System.out.println();

		for (Beer beer : beers) {
			beer.displayAll();
		}

	}

	/**
	 * method orders the beer ArrayList by name
	 * 
	 * @param beers
	 */
	public static void orderBeersByName(List<Beer> beers) {

		Collections.sort(beers, new CompareBeerByName());
		System.out.println("Beers ordered in alphabetical order!");
		System.out.println();

	}

	/**
	 * method orders the beer ArrayList by strength
	 * 
	 * @param beers
	 */
	public static void orderBeersByStrength(List<Beer> beers) {

		Collections.sort(beers, new CompareBeerByStrength());
		System.out.println("Beers ordered by strength - high to low!");
		System.out.println();

	}

	/**
	 * if beers ArrayList contains the given beer name, it is removed and deleted
	 * 
	 * @param name
	 * @param beers
	 */
	public static void deleteBeer(String name, List<Beer> beers) {

		Iterator<Beer> iterator = beers.iterator();
		boolean removed = false;

		while (iterator.hasNext()) {

			if (iterator.next().getName().equalsIgnoreCase(name)) {
				iterator.remove();
				removed = true;
				System.out.println();
				System.out.println(name.toUpperCase() + " has been removed");
				System.out.println();
			}

		}

		if (!removed) {
			System.out.println("No beers by the name of " + name.toUpperCase() + ". Nothing has been removed");
			System.out.println();
		}

	}

	/**
	 * method starts a new thread, and outputs all beers above 6% to new file
	 * 
	 * @param beers
	 */
	public static void outputBeerByStrength(List<Beer> beers) {

		Thread t = new Thread(new OutputBeersThread());
		t.start();
	}

	/**
	 * method adds a beer to the beers ArrayList
	 * 
	 * @param beers
	 * @param sc
	 */
	public static void addBeer(List<Beer> beers, Scanner sc) {

		Beer beer = new Beer();
		String name;
		String style;
		String country;
		double strength;

		System.out.println("Enter the name of the beer you want to add:");
		name = sc.nextLine();
		name = capitalizeWords(name);
		System.out.println();

		System.out.println("Enter the style of the beer:");
		style = sc.nextLine();
		style = capitalizeWords(style);
		System.out.println();

		System.out.println("Enter the country the beer is from:");
		country = sc.nextLine();
		country = capitalizeWords(country);
		System.out.println();

		System.out.println("Enter the strength of the beer:");
		while (!sc.hasNextDouble()) {
			System.out.println("Please enter a number:");
			sc.nextLine(); // clear invalid input
			System.out.println();
		}
		strength = sc.nextDouble();
		sc.nextLine(); // clear rest of line

		beer.setName(name);
		beer.setStyle(style);
		beer.setCountry(country);
		beer.setStrength(strength);

		beers.add(beer);
		addBeerToFile(name, style, country, strength);

		System.out.println();
		System.out.println(name.toUpperCase() + " ADDED!");
		System.out.println();

	}

	/**
	 * method adds a beer to the original beer_data.csv
	 * @param name
	 * @param style
	 * @param country
	 * @param strength
	 */
	private static void addBeerToFile(String name, String style, String country, double strength) {

		File file = new File(BeerAnalyser.BEERS_FILE_PATH);

		try (FileWriter fw = (new FileWriter(file, true)); BufferedWriter bw = new BufferedWriter(fw);) {

			StringBuilder sb = new StringBuilder();

			
			sb.append(name);
			sb.append(",");
			sb.append(style);
			sb.append(",");
			sb.append(country);
			sb.append(",");
			sb.append(strength);
			sb.append("\n");

			fw.append(sb.toString());

		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());
			System.out.println();
		} catch (IOException e) {
			System.err.println("Problem writing to file: " + e.getMessage());
			System.out.println();
		}

	}

	/**
	 * method capitalises the first letter of each word
	 * 
	 * @param name
	 */
	public static String capitalizeWords(String str) {
		// 1. Check for null or empty strings to prevent errors
		if (str == null || str.isEmpty()) {
			return str;
		}

		// 2. Split the string by spaces
		// "\\s+" is a regex that handles single or multiple spaces
		String[] words = str.split("\\s+");

		StringBuilder result = new StringBuilder();

		for (String word : words) {
			// 3. Handle cases where there might be extra spaces (empty strings)
			if (!word.isEmpty()) {
				// Capitalize first letter + append the rest of the word
				result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase())
						.append(" ");
			}
		}

		// 4. Convert to string and trim the trailing space
		return result.toString().trim();
	}

}
