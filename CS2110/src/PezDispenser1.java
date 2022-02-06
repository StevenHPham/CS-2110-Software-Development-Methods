
public class PezDispenser {
		
	public String charName;
	public String sleeveColor;
	public int capacity;
	public int count;
			
	public static void main(String[] args) {
		
	}
	//Constructor
	public PezDispenser() {
		charName = "NewDispenser";
		count = 0;
	}
	
	
	public PezDispenser(String charName, String sleeveColor, int capacity, int count) {
		this.charName = charName;
		this.sleeveColor = sleeveColor;
		this.capacity = capacity;
		this.count = count;
	}
	
	public void load() {
		count = capacity;
	}
	
	//method stub
	public int getCount();
}
