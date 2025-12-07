/**
 * 
 */
package university;

/**
 * represents a MSc Software Development student
 */
public class MScStudent extends Student {

	// constants
	private static final int TOTAL_MODULE_WEIGHTS = 6;

	private int programming; // double weighted
	private int computingFoundations;
	private int dataBases;
	private int webDevelopment;
	private int softwareEngineering;

	private String classification = "Not available"; // default until calculated

	/**
	 * Default constructor
	 */
	public MScStudent() {

	}

	/**
	 * @param programming
	 * @param computingFoundations
	 * @param dataBases
	 * @param webDevelopment
	 * @param softwareEngineering
	 * @param classification
	 */
	public MScStudent(int programming, int computingFoundations, int dataBases, int webDevelopment,
			int softwareEngineering) {
		super();
		this.programming = programming;
		this.computingFoundations = computingFoundations;
		this.dataBases = dataBases;
		this.webDevelopment = webDevelopment;
		this.softwareEngineering = softwareEngineering;

	}

	/**
	 * @return the programming
	 */
	public int getProgramming() {
		return programming;
	}

	/**
	 * @param programming the programming to set
	 */
	public void setProgramming(int programming) {
		this.programming = programming;
	}

	/**
	 * @return the computingFoundations
	 */
	public int getComputingFoundations() {
		return computingFoundations;
	}

	/**
	 * @param computingFoundations the computingFoundations to set
	 */
	public void setComputingFoundations(int computingFoundations) {
		this.computingFoundations = computingFoundations;
	}

	/**
	 * @return the dataBases
	 */
	public int getDataBases() {
		return dataBases;
	}

	/**
	 * @param dataBases the dataBases to set
	 */
	public void setDataBases(int dataBases) {
		this.dataBases = dataBases;
	}

	/**
	 * @return the webDevelopment
	 */
	public int getWebDevelopment() {
		return webDevelopment;
	}

	/**
	 * @param webDevelopment the webDevelopment to set
	 */
	public void setWebDevelopment(int webDevelopment) {
		this.webDevelopment = webDevelopment;
	}

	/**
	 * @return the softwareEngineering
	 */
	public int getSoftwareEngineering() {
		return softwareEngineering;
	}

	/**
	 * @param softwareEngineering the softwareEngineering to set
	 */
	public void setSoftwareEngineering(int softwareEngineering) {
		this.softwareEngineering = softwareEngineering;
	}

	/**
	 * @return the classification
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * method calculates the students average across 5 modules - programming is
	 * double weighted so average is divisible by 6
	 * 
	 * @return
	 */
	private int calculateAverage() {

		return ((this.programming * 2) + this.computingFoundations + this.dataBases + this.webDevelopment
				+ this.softwareEngineering) / TOTAL_MODULE_WEIGHTS;
	}

	/**
	 * method calculates the classification of the student
	 */
	public void calculateClassification() {
		int taughtAverage = this.calculateAverage();

		if (taughtAverage < 0 || taughtAverage > 100) {
			this.classification = "Error";
		} else if (taughtAverage >= 70 && taughtAverage <= 100) {
			this.classification = "Distinction";
		} else if (taughtAverage >= 60 && taughtAverage <= 69) {
			this.classification = "Commendation";
		} else if (taughtAverage >= 50 && taughtAverage <= 59) {
			this.classification = "Pass";
		} else {
			this.classification = "Fail";
		}
	}

	/**
	 * method displays all students details to the console
	 */
	@Override
	public void displayAll() {
		super.displayAll();
		System.out.println();
		System.out.println("MODULE RESULTS");
		System.out.println("Programming\t:  " + this.programming);
		System.out.println("Comp Found\t:  " + this.computingFoundations);
		System.out.println("Databases\t:  " + this.dataBases);
		System.out.println("Web Development\t:  " + this.webDevelopment);
		System.out.println("Software Eng\t:  " + this.softwareEngineering);
		System.out.println();
		System.out.println("Average\t\t:  " + this.calculateAverage());
		System.out.println();
		System.out.println("Classification\t:  " + this.classification);
		System.out.println();
		System.out.println("------------------------------");
		System.out.println();

	}


	/**
	 * method displays the students classification to the console
	 */
	public void displayStudentClassification() {
		super.displayAll();
		System.out.println();
		System.out.println("Average\t\t:  " + this.calculateAverage());
		System.out.println();
		System.out.println("Classification\t:  " + this.classification);
		System.out.println();
		System.out.println("------------------------------");
		System.out.println();
		
		
	}

}
