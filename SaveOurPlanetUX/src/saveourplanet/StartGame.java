/**
 * Ryan McCloy - 40477955
 */
package saveourplanet;

/**
 * Where the console based board game will be played
 */
public class StartGame {

	/**
	 * start point of application
	 * @param args
	 */
	public static void main(String[] args) {
		
		SoundPlayer sounds = new SoundPlayer();
		Dice dice = new Dice();
		
//		sounds.playSound("startingMenu", true);
		
		dice.rollDiceAnimation(1, 2);
		dice.rollDiceAnimation(3, 4);
		dice.rollDiceAnimation(5, 1);
		dice.rollDiceAnimation(6, 1);
		
		
//		try {
//			
//			Thread.sleep(100000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
	
	

}
