/**
 * 
 */
package university;

/**
 * represents a student
 */
public abstract class Student {
	
	
	private int studentNumber;
	private String firstName;
	private String lastName;

	/**
	 * Default constructor
	 */
	public Student() {
		
	}

	/**
	 * Constructor with arguments
	 * 
	 * @param studentNumber
	 * @param firstName
	 * @param lastName
	 */
	public Student(int studentNumber, String firstName, String lastName) {
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the studentNumber
	 */
	public int getStudentNumber() {
		return studentNumber;
	}

	/**
	 * @param studentNumber the studentNumber to set
	 */
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * method displays student details to console
	 */
	public void displayAll() {
		System.out.println("Student number\t:  " + this.studentNumber );
		System.out.println("First name\t:  " + this.firstName);
		System.out.println("Last name\t:  " + this.lastName);
	}
	
	

}
