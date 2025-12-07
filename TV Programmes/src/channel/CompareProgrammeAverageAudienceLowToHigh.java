/**
 * 
 */
package channel;

import java.util.Comparator;

/**
 * method sorts programmes from lowest average audience to highest
 */
public class CompareProgrammeAverageAudienceLowToHigh implements Comparator<Programme> {

	@Override
	public int compare(Programme o1, Programme o2) {
		return Double.compare(o1.getAverageAudience(), o2.getAverageAudience());
	}
}
