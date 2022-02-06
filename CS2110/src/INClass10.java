import java.util.HashSet;
public class INClass10 {
	
	public HashSet<String> names(HashSet<String> cards, HashSet<String> topNames ){
		HashSet<String> addName = new HashSet<String>();
		for (String name: cards) {
			if (topNames.contains(name)) {
				addName = addName;
			} else {
				addName.add(name);
			}
		}
		return addName;
	}
}
