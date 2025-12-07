/**
 * 
 */
package university;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

/**
 * thread prints student classifications to a new file
 */
public class PrintClassificationsThread implements Runnable {

	@Override
	public void run() {
		printClassifications();
	}

	/**
	 * creates a file and appends the students classifications
	 */
	private void printClassifications() {
		File file = new File("ListForGraduation.txt");
		
		System.out.println("Printing classifications...");
		
		try (FileWriter fr = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fr);) {
			
			for (MScStudent student : ExamResultProcessor.students) {
				
				StringBuilder sb = new StringBuilder();
				
				//student number, first name, last name and classification
				sb.append(student.getStudentNumber());
				sb.append(",");
				sb.append(student.getFirstName());
				sb.append(",");
				sb.append(student.getLastName());
				sb.append(",");
				sb.append(student.getClassification());
				sb.append("\n");
				
				bw.append(sb.toString());
				
			}
			
			
		} catch (FileNotFoundException e) {
			System.err.println("File not found : " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Classifications printed. Ready for graduation! :)");
		System.out.println();
		
	}
	
	
	

}
