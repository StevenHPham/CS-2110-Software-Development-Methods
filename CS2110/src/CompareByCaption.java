import java.util.*;

public class CompareByCaption implements Comparator<Photograph> {

	/**
	 * Compares two photos by the caption, if the caption is the same, compare by the ratings
	 */

	@Override
	public int compare(Photograph o1, Photograph o2) {
		int a = o1.caption.compareTo(o2.caption);
		if (a == 0) {
			return (-1 * (o1.getRating() - o2.getRating()));
			
		}
		return a;
	}
}

