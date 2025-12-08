/**
 * 
 */
package beers;

/**
 * represents a beer
 */
public class Beer {

	// instance variables
	private String name;
	private String style;
	private String country;
	private double strength;

	/**
	 * Default constructor
	 */
	public Beer() {
 
	}

	/**
	 * Constructor using arguments. Initialised the Beer instance with the given
	 * instance variable
	 * 
	 * @param name
	 * @param style
	 * @param country
	 * @param strength
	 */
	public Beer(String name, String style, String country, double strength) {
		this.name = name;
		this.style = style;
		this.country = country;
		this.strength = strength;
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
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * @param style the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the strength
	 */
	public double getStrength() {
		return strength;
	}

	/**
	 * @param strength the strength to set
	 */
	public void setStrength(double strength) {
		this.strength = strength;
	}

	/**
	 * displays all beer details to the console
	 */
	public void displayAll() {
		System.out.println("Name\t:  " + this.name.toUpperCase());
		System.out.println("Style\t:  " + this.style);
		System.out.println("Country\t:  " + this.country);
		System.out.printf("%s\t:  %.1f","Alc %", this.strength);
		System.out.println();
		System.out.println("------------------------");
		System.out.println();
	}

}
