/**
 * 
 */
package sims;

/**
 * represents a person
 */
public class Person {

	private String firstName;
	
	/**
	 * default constructor
	 */
	public Person() {
		
	}

	/**
	 * @param firstName
	 */
	public Person(String firstName) {
		this.firstName = firstName;
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
	
	
	
}
