/**
 * 
 */
package sims;

import java.util.ArrayList;

/**
 * simulates a very simple sims game
 */
public class SimsGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// array of diners
		ArrayList<Person> diners = new ArrayList<Person>();
		Person person1, person2, person3;
		person1 = new Person("Layne");
		person2 = new Person("Jerry");
		person3 = new Person("Mike");
		diners.add(person1);
		diners.add(person2);
		diners.add(person3);
		
		// array of pests
		ArrayList<Pest> pests = new ArrayList<Pest>();
		HouseFly housefly = new HouseFly();
		TeleSales telesales = new TeleSales();
		pests.add(housefly);
		pests.add(telesales);
		
		// creating the dining room
		DiningRoom diningRoom = new DiningRoom(pests, diners);
		
		// serving food
		diningRoom.serveFood();

	}

}
