/**
 * 
 */
package beers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * thread outputs all beers above 6% strength to a new file
 */
public class OutputBeersThread implements Runnable {

	private static final String OUTPUT_FILE_NAME = "beers_above_6.txt";

	@Override
	public void run() {
		
		try {
			List<Beer> beersAbove6 = getBeersAbove6(BeerAnalyser.beers);
			outputBeersToFile(beersAbove6);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	/**
	 * method returns an ArrayList of all the beers above 6% strength
	 * 
	 * @param beers
	 * @return
	 */
	private List<Beer> getBeersAbove6(List<Beer> beers) {
		
		List<Beer> results = new ArrayList<Beer>();
		
		for (Beer beer : beers) {
			if (beer.getStrength() > 6) {
				results.add(beer);
			}
		}
		
		return results;
	}
	
	
	/**
	 * Thread outputs all beers above 6% from the given ArrayList to a new file
	 * @param beersAbove6
	 */
	private void outputBeersToFile(List<Beer> beersAbove6) {
		
		File file = new File(OUTPUT_FILE_NAME);
		int count = 0;
		
		System.out.println("Writing beers to file...");
		
		try  (FileWriter fw = new FileWriter(file); BufferedWriter br = new BufferedWriter(fw);){
			
			for (Beer beer : beersAbove6) {
				
				StringBuilder sb = new StringBuilder();
				
				sb.append(beer.getName());
				sb.append(",");
				sb.append(beer.getStyle());
				sb.append(",");
				sb.append(beer.getCountry());
				sb.append(",");
				sb.append(beer.getStrength());
				sb.append("\n"); // newline
				
				br.write(sb.toString());
				count++;
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem writing to file: " + e.getMessage());
		}
		
		System.out.println("File write complete! Number of beers written: " + count);
		System.out.println();
		
	}

}
