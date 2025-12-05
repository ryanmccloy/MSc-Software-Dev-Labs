/**
 * 
 */
package channel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class ProgrammeTest {

	// test data
	Programme programme;

	String nameValid;

	Broadcaster broadcasterValid1;
	Broadcaster broadcasterValid2;
	Broadcaster broadcasterValid3;
	Broadcaster broadcasterValid4;
	Broadcaster broadcasterValid5;
	Broadcaster broadcasterValid6;
	Broadcaster broadcasterValid7;

	int ratingValidLowerBoundary;
	int ratingValidLower;
	int ratingValidMid;
	int ratingValidUpper;
	int ratingValidUpperBoundary;
	int ratingInvalidLower;
	int ratingInvalidLowerBoundary;
	int ratingInvalidUpperBoundary;
	int ratingInvalidUpper;

	double averageAudienceValid;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		programme = new Programme();

		broadcasterValid1 = Broadcaster.BBC;
		broadcasterValid2 = Broadcaster.ITV;
		broadcasterValid3 = Broadcaster.NETFLIX;
		broadcasterValid4 = Broadcaster.AMAZON_PRIME;
		broadcasterValid5 = Broadcaster.APPLE_TV;
		broadcasterValid6 = Broadcaster.HBO;
		broadcasterValid7 = Broadcaster.CHANNEL_4;

		ratingValidLowerBoundary = 0;
		ratingValidLower = 1;
		ratingValidMid = 5;
		ratingValidUpper = 9;
		ratingValidUpperBoundary = 10;
		ratingInvalidLower = -5;
		ratingInvalidLowerBoundary = -1;
		ratingInvalidUpperBoundary = 11;
		ratingInvalidUpper = 15;

		averageAudienceValid = 5.5;
	}

	/**
	 * Test method for {@link channel.Programme#Programme()}.
	 */
	@Test
	void testProgrammeDefaultConstructor() {
		assertNotNull(programme);
	}

	/**
	 * Test method for
	 * {@link channel.Programme#Programme(java.lang.String, channel.Broadcaster, int, double)}.
	 */
	@Test
	void testProgrammeConstructorWithArgumentsValid() {
		programme = new Programme(nameValid, broadcasterValid1, ratingValidMid, averageAudienceValid);

		assertEquals(nameValid, programme.getName());
		assertEquals(broadcasterValid1, programme.getBroadcaster());
		assertEquals(ratingValidMid, programme.getRating());
		assertEquals(averageAudienceValid, programme.getAverageAudience());
	}

	/**
	 * Test method for
	 * {@link channel.Programme#Programme(java.lang.String, channel.Broadcaster, int, double)}.
	 */
	@Test
	void testProgrammeConstructorWithArgumentsInvalid() {

		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			programme = new Programme(nameValid, broadcasterValid1, ratingInvalidLower, averageAudienceValid);
		});

		assertEquals("Invalid rating. Must be between 0 & 10", e.getMessage());

	}

	/**
	 * Test method for {@link channel.Programme#getName()}.
	 */
	@Test
	void testGetSetName() {
		
		programme.setName(nameValid);
		assertEquals(nameValid, programme.getName());
		
	}

	/**
	 * Test method for {@link channel.Programme#getBroadcaster()}.
	 */
	@Test
	void testGetSetBroadcaster() {
		
		programme.setBroadcaster(broadcasterValid1);
		assertEquals(broadcasterValid1, programme.getBroadcaster());
		
		programme.setBroadcaster(broadcasterValid2);
		assertEquals(broadcasterValid2, programme.getBroadcaster());
		
		programme.setBroadcaster(broadcasterValid3);
		assertEquals(broadcasterValid3, programme.getBroadcaster());
		
		programme.setBroadcaster(broadcasterValid4);
		assertEquals(broadcasterValid4, programme.getBroadcaster());
		
		programme.setBroadcaster(broadcasterValid5);
		assertEquals(broadcasterValid5, programme.getBroadcaster());
		
		programme.setBroadcaster(broadcasterValid6);
		assertEquals(broadcasterValid6, programme.getBroadcaster());
		
		programme.setBroadcaster(broadcasterValid7);
		assertEquals(broadcasterValid7, programme.getBroadcaster());
		
	}

	/**
	 * Test method for {@link channel.Programme#getRating()}.
	 */
	@Test
	void testGetSetRatingValid() {
		
		programme.setRating(ratingValidLowerBoundary);
		assertEquals(ratingValidLowerBoundary, programme.getRating());
		
		programme.setRating(ratingValidLower);
		assertEquals(ratingValidLower, programme.getRating());
		
		programme.setRating(ratingValidMid);
		assertEquals(ratingValidMid, programme.getRating());
		
		programme.setRating(ratingValidUpper);
		assertEquals(ratingValidUpper, programme.getRating());
		
		programme.setRating(ratingValidUpperBoundary);
		assertEquals(ratingValidUpperBoundary, programme.getRating());
		
	}
	
	/**
	 * Test method for {@link channel.Programme#getRating()}.
	 */
	@Test
	void testGetSetRatingInvalid() {
		
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			programme.setRating(ratingInvalidLower);
		});
		assertEquals("Invalid rating. Must be between 0 & 10", e.getMessage());
		
		e = assertThrows(IllegalArgumentException.class, () -> {
			programme.setRating(ratingInvalidLowerBoundary);
		});
		assertEquals("Invalid rating. Must be between 0 & 10", e.getMessage());

		
		e = assertThrows(IllegalArgumentException.class, () -> {
			programme.setRating(ratingInvalidUpper);
		});
		assertEquals("Invalid rating. Must be between 0 & 10", e.getMessage());

		
		e = assertThrows(IllegalArgumentException.class, () -> {
			programme.setRating(ratingInvalidUpperBoundary);
		});
		assertEquals("Invalid rating. Must be between 0 & 10", e.getMessage());


	}


	/**
	 * Test method for {@link channel.Programme#getAverageAudience()}.
	 */
	@Test
	void testGetSetAverageAudience() {
		
		programme.setAverageAudience(averageAudienceValid);
		assertEquals(averageAudienceValid, programme.getAverageAudience());
		
	}

}
