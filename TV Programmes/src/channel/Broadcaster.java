/**
 * 
 */
package channel;

/**
 * accepted broadcasters
 */
public enum Broadcaster {
	BBC("BBC"), ITV("ITV"), NETFLIX("Netflix"), AMAZON_PRIME("Amazon Prime"), APPLE_TV("Apple TV"),
	CHANNEL_4("Channel 4"), HBO("HBO");

	private String description;

	/**
	 * constructor 
	 */
	private Broadcaster(String description) {
		this.description = description;
	}
	
	/**
	 * gets the Broadcaster description
	 * @return
	 */
	public String getDescription() {
		return this.description;
	}

}
