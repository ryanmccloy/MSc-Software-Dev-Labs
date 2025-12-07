/**
 * 
 */
package channel;

import java.util.Comparator;

/**
 * method sorts programmes from highest average audience to lowest
 */
public class CompareProgrammeAverageAudienceHighToLow implements Comparator<Programme> {

	@Override
	public int compare(Programme o1, Programme o2) {
		return Double.compare(o2.getAverageAudience(), o1.getAverageAudience());
	}

}
 