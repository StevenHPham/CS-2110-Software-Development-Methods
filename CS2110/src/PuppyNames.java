import java.util.*;



public class PuppyNames {
	
	
	
	public HashSet<String> names(HashSet<String> cards, HashSet<String> topNames) {
		HashSet<String> chosen = new HashSet<String>();
		for (String card: cards) {
			chosen.add(card);
		}
		for (String name : topNames) {
			chosen.add(name);
		}
		return chosen;
		
	}

	public static void main(String[] args) {
		
		
		
		HashSet<String> myChosen = new HashSet<String>();
		myChosen.add("boy1");
		myChosen.add("boy2");
		myChosen.add("boy3");
		
		HashSet<String> topNames = new HashSet<String>();
		topNames.add("boy1");
		topNames.add("boy2");
		topNames.add("boy3");
		topNames.add("boy4");
		
		PuppyNames name = new PuppyNames();
		
		System.out.println(name.names(myChosen,topNames));
		
	
		
		

		
		
		
	}

}
