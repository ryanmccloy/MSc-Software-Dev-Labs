package channel;

import java.util.Comparator;

public class CompareProgrammeRatingLowToHigh implements Comparator<Programme> {

	@Override
	public int compare(Programme o1, Programme o2) {
		return o1.getRating() - o2.getRating();
	}

}
