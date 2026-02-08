/**
 * Ryan McCloy - 40477955
 */
package saveourplanet;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Class contains methods used for playing sound effects in the console based
 * game.
 */
public class SoundPlayer {

	// storing current clip so it can be faded out if necessary
	private Clip clip;

	/**
	 * Plays a .wav audio file from the assets folder.
	 * 
	 * @param filename - The name of the file WITHOUT the extension (e.g., "menu_theme")
     * @param loop     - Set to true for background music, false for sound effects.
	 */
	public void playSound(String fileName, boolean loop) {

	
		// create the distinct file path 
		String finalPath = "assets/" + fileName + ".wav";

		try {
			// create the File object relative to the project root
			File soundFile = new File(finalPath);
			
			// check if the sound file exists
			if (!soundFile.exists()) {
				System.err.println("Error: Sound file not found at " + finalPath);
				return;
			}

			// open the audio stream
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

			// assign to class level variable
			this.clip = AudioSystem.getClip();

			this.clip.open(audioIn);

			// loop continuously if needed
			if (loop) {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}

			// start play back
			clip.start();

		} catch (Exception e) {
			System.err.println("Something went wrong playing sound: " + e.getMessage());
		}

	}

	
	/**
	 * stops the clip audio
	 */
	public void endSound() {
		if (this.clip != null && this.clip.isRunning()) {
			this.clip.stop();
		}
	}

}
