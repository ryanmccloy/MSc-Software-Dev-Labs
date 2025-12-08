/**
 * 
 */
package beers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit testing of the Beer class. Only positive testing for now as no business rules implemented
 */
class BeerTest {

	// test data
	Beer beer; 

	String nameValid;
	String styleValid;
	String countryValid;
	double strengthValid;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		beer = new Beer();

		nameValid = "Beer Name";
		styleValid = "Beer Style";
		countryValid = "Beer country";
		strengthValid = 5.5;

	}

	/**
	 * Test method for {@link beers.Beer#Beer()}.
	 */
	@Test
	void testBeerDefaultConstructor() {
		assertNotNull(beer);
	}

	/**
	 * Test method for
	 * {@link beers.Beer#Beer(java.lang.String, java.lang.String, java.lang.String, double)}.
	 */
	@Test
	void testBeerConstructorWithArguments() {
		beer = new Beer(nameValid, styleValid, countryValid, strengthValid);
		
		assertEquals(nameValid, beer.getName());
		assertEquals(styleValid, beer.getStyle());
		assertEquals(countryValid, beer.getCountry());
		assertEquals(strengthValid, beer.getStrength(), 0.1);
	}

	/**
	 * Test method for {@link beers.Beer#getName()}.
	 */
	@Test
	void testGetSetName() {
		
		beer.setName(nameValid);
		assertEquals(nameValid, beer.getName());
		
	}

	/**
	 * Test method for {@link beers.Beer#getStyle()}.
	 */
	@Test
	void testGetSetStyle() {
		
		beer.setStyle(styleValid);
		assertEquals(styleValid, beer.getStyle());
		
	}

	/**
	 * Test method for {@link beers.Beer#getCountry()}.
	 */
	@Test
	void testGetSetCountry() {
		
		beer.setCountry(countryValid);
		assertEquals(countryValid, beer.getCountry());
		
	}

	/**
	 * Test method for {@link beers.Beer#getStrength()}.
	 */
	@Test
	void testGetSetStrength() {
		
		beer.setStrength(strengthValid);
		assertEquals(strengthValid, beer.getStrength(), 0.1);
	}

}
