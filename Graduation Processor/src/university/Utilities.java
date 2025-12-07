/**
 * 
 */
package university;

import java.util.List;

/**
 * Utility methods for ExamResultProcessor
 */
public class Utilities {

	/**
	 * displays all students details to the console
	 * @param students
	 */
	public static void displayAllStudentsDetails(List<MScStudent> students) {
		
		for (MScStudent student : students) {
			student.displayAll();
		}
		
	}

	/**
	 * calculates all students final classifications
	 * @param students
	 */
	public static void calculateAllStudentClassifications(List<MScStudent> students) {
		
		for (MScStudent student : students) {
			student.calculateClassification();
		}
		
	}

	/**
	 * displays all the student classifications to the console
	 * @param students
	 */
	public static void displayAllStudentClassifications(List<MScStudent> students) {
		
		for (MScStudent student : students) {
			student.displayStudentClassification();
		}
		
	}

	
}
