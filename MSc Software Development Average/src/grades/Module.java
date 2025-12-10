/**
 * 
 */
package grades;

import java.util.Map;

/**
 * class represents the parent class of all modules
 */
public class Module {

	// instance variables
	private String name;
	private boolean doubleWeighted;
	private Map<Integer, int[]> marks;
	private double average;

	/**
	 * default constructor
	 */
	public Module() {

	}

	/**
	 * constructor using arguments
	 * 
	 * @param name
	 * @param average
	 * @param doubleWeighted
	 */
	public Module(String name, boolean doubleWeighted, Map<Integer, int[]> marks) {
		this.name = name;
		this.doubleWeighted = doubleWeighted;
		this.marks = marks;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the doubleWeighted
	 */
	public boolean isDoubleWeighted() {
		return doubleWeighted;
	}

	/**
	 * @param doubleWeighted the doubleWeighted to set
	 */
	public void setDoubleWeighted(boolean doubleWeighted) {
		this.doubleWeighted = doubleWeighted;
	}

	/**
	 * @return the marks
	 */
	public Map<Integer, int[]> getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(Map<Integer, int[]> marks) {
		this.marks = marks;
	}

	/**
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}

	/**
	 * @param average the average to set
	 */
	public void setAverage(double average) {
		this.average = average;
	}

	/**
	 * calculates the average grade for the module
	 * 
	 * @return
	 */
	public void calculateAverage() {

		int totalMarksAchieved = 0;
		int totalMarksAvailable = 0;

		for (Integer assessment : marks.keySet()) {

			totalMarksAchieved += marks.get(assessment)[0];
			totalMarksAvailable += marks.get(assessment)[1];

		}

		this.average = (((double) totalMarksAchieved / totalMarksAvailable) * 100);

	};

	/**
	 * displays module details to the console
	 */
	public void displayAll() {
		System.out.println("Module\t:  " + MScCalculationCalculator.BOLD_TEXT + this.name.toUpperCase() + MScCalculationCalculator.RESET_TEXT);
		System.out.println("Weight\t:  " + (doubleWeighted ? "Double" : "Single"));
		System.out.printf("Average\t:  %s%.2f%s%s%n", MScCalculationCalculator.GREEN_TEXT, this.average, "%", MScCalculationCalculator.RESET_TEXT);
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println();
		;
	}

}
