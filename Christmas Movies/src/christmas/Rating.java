/**
 * 
 */
package christmas; 

/**
 * acceptable ratings for movies
 */
public enum Rating {
	PG("PG"), G("G"), U("U"), PG_THIRTEEN("PG-13"), TWELVE("12"), FIFTEEN("15"), ERROR("Error");
	
	private String description;
	
	/**
	 * constructor to set the description of the Enum
	 * @param description
	 */
	Rating(String description) {
		this.description = description;
	}
	
	/**
	 * returns the description
	 * @return
	 */
	public String getDescription() {
		return this.description;
	}
}
