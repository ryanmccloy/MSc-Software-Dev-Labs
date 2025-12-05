/**
 * 
 */
package channel;

/**
 * class represents a TV programme
 */
public class Programme {


	/**
	 * constants for business rules
	 */
	private final int RATING_LOWER_BOUNDARY = 0;
	private final int RATING_UPPER_BOUNDARY = 10;

	// instance variables
	String name;
	Broadcaster broadcaster; 
	int rating;
	double averageAudience;

	/**
	 * constructor with arguments
	 * 
	 * @param name
	 * @param broadcaster
	 * @param rating
	 * @param averageAudience
	 */
	public Programme(String name, Broadcaster broadcaster, int rating, double averageAudience) throws IllegalArgumentException {
		this.name = name;
		this.broadcaster = broadcaster;
		this.setRating(rating);
		this.averageAudience = averageAudience;
	}

	/**
	 * Default constructor
	 */
	public Programme() {

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
	 * @return the broadcaster
	 */
	public Broadcaster getBroadcaster() {
		return broadcaster;
	}

	/**
	 * @param broadcaster the broadcaster to set
	 */
	public void setBroadcaster(Broadcaster broadcaster) {
		this.broadcaster = broadcaster;
	}

	/**
	 * @return the rating
	 */
	public int getRating() { 
		return rating;
	}

	/**
	 * 
	 * @param rating
	 * @throws IllegalArgumentException
	 */
	public void setRating(int rating) throws IllegalArgumentException {
		if (rating >= RATING_LOWER_BOUNDARY && rating <= RATING_UPPER_BOUNDARY) {
			this.rating = rating;
		} else {
			throw new IllegalArgumentException("Invalid rating. Must be between 0 & 10");
		}

	}

	/**
	 * @return the averageAudience
	 */
	public double getAverageAudience() {
		return averageAudience;
	}

	/**
	 * @param averageAudience the averageAudience to set
	 */
	public void setAverageAudience(double averageAudience) {
		this.averageAudience = averageAudience;
	}

	/**
	 * method displays all programme details to the console
	 */
	public void displayAll() {
		System.out.println("Programme \t:  " + this.name.toUpperCase());
		System.out.println("Broadcaster \t:  " + this.broadcaster.getDescription());
		System.out.println("Rating \t\t:  " + this.rating);
		System.out.printf("Ave Audience \t:  %.2f (million)\n", this.averageAudience);
		System.out.println("----------------------------------");
		System.out.println();
	}

}
