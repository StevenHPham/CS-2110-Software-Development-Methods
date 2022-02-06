import java.util.Comparator;

public class CompareByRating implements Comparator<Photograph>{
	/**
	 * Compares two photos by their ratings. If the ratings are the same, 
	 * compare the caption instead
	 */
	@Override
	public int compare(Photograph o1, Photograph o2) {
		int a = (o1.getRating() - o2.getRating()) * -1;
		if ( a == 0 ) {
			return o1.getCaption().compareTo(o2.getCaption());
		}
		return a;
	}
}