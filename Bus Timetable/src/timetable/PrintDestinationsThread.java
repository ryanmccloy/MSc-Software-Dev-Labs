/**
 * 
 */
package timetable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * 
 */
public class PrintDestinationsThread implements Runnable {

	@Override
	public void run() {
		System.err.println("Printing the file ...");
		// in a new thread
		printToFile();

		System.err.println("Printed the file ...");
	}

	/**
	 * prints bus route destinations to a new file
	 */
	private void printToFile() {
		
		try {
			
			FileWriter fw = new FileWriter(new File("All_destinations.txt"));
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (BusRoute busRoute : JourneyPlanner.busRoutes) {
				
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(busRoute.getRouteId());
				stringBuilder.append(",");
				stringBuilder.append(busRoute.getArrival());
				stringBuilder.append(",");
				stringBuilder.append(busRoute.getTravelMinutes());
				stringBuilder.append("\n"); // important
				System.out.println("About to write to file " + stringBuilder.toString());
				bw.append(stringBuilder.toString());
			}
			
			bw.close();
			fw.close();
			
		} catch(Exception e) {
			System.out.println("Problem printing.. " + e.getMessage());
		}
		
	}

}
