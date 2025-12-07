/**
 * 
 */
package channel;

import java.util.Comparator;

/**
 * 
 */
public class CompareProgrammeRatingHighToLow implements Comparator<Programme> {

	@Override
	public int compare(Programme o1, Programme o2) {
		return o2.getRating() - o1.getRating();
	}

}
 