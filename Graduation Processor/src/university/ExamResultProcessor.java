/**
 * 
 */
package university;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class ExamResultProcessor {

	/**
	 * Constants for text formatting
	 */
	final static String RED_TEXT = "\033[0;31m";
	final static String GREEN_TEXT = "\033[0;32m";
	final static String BOLD_TEXT = "\033[1m";
	final static String RESET_TEXT = "\033[0m";

	public static List<MScStudent> students = new ArrayList<MScStudent>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("EXAM RESULT PROCESSOR STARTED");
		System.out.println("-----------------------------");
		System.out.println();

		try {
			readFiles("ModuleScoresMSC.csv");
			showMenu();

		} catch (Exception e) {
			System.err.println("Sorry there has been a problem! Please contact the admin.");
		}

		System.out.println();
		System.out.println("----------------------------");
		System.out.println("EXAM RESULT PROCESSOR CLOSED");

	}

	/**
	 * method reads student records from a given CSV and stores them in MSc object
	 * within the students ArrayList
	 * 
	 * @param path
	 */
	private static void readFiles(String path) {
		File file = new File(path);
		String data;

		System.out.println("Reading students from file...");

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
			br.readLine(); // clear header

			while ((data = br.readLine()) != null) {
				// create student instance
				MScStudent student = new MScStudent();
				String[] dataParts = data.split(",");

				// student number
				try {
					student.setStudentNumber(Integer.parseInt(dataParts[0]));
				} catch (NumberFormatException e) {
					System.err.println("Problem with student number. Defaulting to 123456789");
				}

				// firstName
				student.setFirstName(dataParts[1]);

				// lastName
				student.setLastName(dataParts[2]);

				// programming
				try {
					student.setProgramming(Integer.parseInt(dataParts[3]));
				} catch (NumberFormatException e) {
					System.err.println("Problem with programming grade. Skipping student...");
					continue;
				}

				// computingFoundations
				try {
					student.setComputingFoundations(Integer.parseInt(dataParts[4]));
				} catch (NumberFormatException e) {
					System.err.println("Problem with computing foundations grade. Skipping student...");
					continue;
				}

				// databases
				try {
					student.setDataBases(Integer.parseInt(dataParts[5]));
				} catch (NumberFormatException e) {
					System.err.println("Problem with databases grade. Skipping student...");
					continue;
				}

				// webDevelopment
				try {
					student.setWebDevelopment(Integer.parseInt(dataParts[6]));
				} catch (NumberFormatException e) {
					System.err.println("Problem with web development grade. Skipping student...");
					continue;
				}

				// softwareEngineering
				try {
					student.setSoftwareEngineering(Integer.parseInt(dataParts[7]));
				} catch (NumberFormatException e) {
					System.err.println("Problem with software engineering grade. Skipping student...");
					continue;
				}

				// add student instance to students ArrayList
				students.add(student);
			}

		} catch (IOException e) {
			System.err.println("Problem reading from file : " + e.getMessage());
		}

		// statistics
		System.out.println("File read complete. Students processed : " + students.size());
		System.out.println();

	}

	/**
	 * method shows a menu to the user allowing them to calculate the student
	 * classifications, print them to the console, and print the classifications to
	 * a new file for graduation
	 */
	private static void showMenu() {
		Scanner sc = new Scanner(System.in);
		int choice;
		boolean gradesClassified = false;

		do {

			// small delay to allow user time to see output before showing menu again
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// menu
			System.out.println(GREEN_TEXT);
			System.out.println("1. Show all students details");
			System.out.println("2. Calculate students final classifications");
			System.out.println("3. Show all students final classifications");
			System.out.println("4. Print students classifications");
			System.out.println("0. Quit");
			System.out.println();
			System.out.println("Enter your choice:");
			System.out.println(RESET_TEXT);

			while (!sc.hasNextInt()) {
				System.out.println("Please enter a number:");
				sc.nextLine(); // clearing invalid characters
				System.out.println();
			}

			choice = sc.nextInt();
			sc.nextLine(); // clearing rest of line
			System.out.println();

			switch (choice) {
			case 1:
				System.out.println(BOLD_TEXT + "ALL STUDENTS DETAILS" + RESET_TEXT);
				System.out.println();
				Utilities.displayAllStudentsDetails(students);
				break;
			case 2:
				Utilities.calculateAllStudentClassifications(students);
				gradesClassified = true;
				System.out.println(BOLD_TEXT + "ALL GRADES CLASSIFIED" + RESET_TEXT);
				System.out.println();
				break;
			case 3:
				if (gradesClassified) {
					System.out.println(BOLD_TEXT + "ALL STUDENTS CLASSIFICATIONS" + RESET_TEXT);
					System.out.println();
					Utilities.displayAllStudentClassifications(students);
				} else {
					System.err.println("You must classify the grades first. Please select option 2...");
					System.out.println();
				}
				break;
			case 4:
				if (gradesClassified) {
					Thread t = new Thread(new PrintClassificationsThread());
					t.start();
				} else {
					System.err.println("You must classify the grades first. Please select option 2...");
					System.out.println();
				}
				break;
			case 0:
				choice = 0;
				System.out.println("See you next year!");
				break;
			default:
				System.out.println("Invalid choice. Please try again...");

			}

			// show all details

			// calculate classifications

			// show classifications

			// print classification to file

			// quit

		} while (choice != 0);

		sc.close();
	}

}
