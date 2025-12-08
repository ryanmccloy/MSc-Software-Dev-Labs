/**
 * 
 */
package christmas;
 
/**
 * acceptable movie genres
 */
public enum Genre {
	COMEDY("Comedy"), FAMILY("Family"), ANIMATION("Animation"), FANTASY("Fantasy"), ROMANCE("Romance"), DRAMA("Drama"), MUSICAL("Musical"), WAR("War"), ERROR("Error");
	
	private String description;
	
	
	/**
	 * constructor to set the description of the Enum
	 * @param description
	 */
	Genre(String description) {
		this.description = description;
	}

	/**]
	 * returns the description 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	
	
}
