/**
 * 
 */
package sims;

import java.util.ArrayList;

/**
 * Dining room which accepts several diners and several pests
 */
public class DiningRoom {
	
	private ArrayList<Pest> pests;
	private ArrayList<Person> diners;
	
	/**
	 * default constructor
	 */
	public DiningRoom() {
		
	}
	
	/**
	 * @param pests
	 * @param diners
	 */
	public DiningRoom(ArrayList<Pest> pests, ArrayList<Person> diners) {
		this.pests = pests;
		this.diners = diners;
	}
	
	/**
	 * serve food with pests being annoying
	 */
	public void serveFood() {
		System.out.println("Serving food");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (Pest pest : pests) {
			pest.beAnnoying();
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Dinner ruined!");
	}

	/**
	 * @return the pests
	 */
	public ArrayList<Pest> getPests() {
		return pests;
	}

	/**
	 * @param pests the pests to set
	 */
	public void setPests(ArrayList<Pest> pests) {
		this.pests = pests;
	}

	/**
	 * @return the diners
	 */
	public ArrayList<Person> getDiners() {
		return diners;
	}

	/**
	 * @param diners the diners to set
	 */
	public void setDiners(ArrayList<Person> diners) {
		this.diners = diners;
	}
	
	

}
