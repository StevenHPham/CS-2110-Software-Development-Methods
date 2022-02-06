
public class Cat extends Animal {
	String breed;
	
	public Cat(String name) {
		super(name);
	}
	
	public Cat(String name, String breed) {
		super(name);
		this.breed = breed;
	}
	
	public String makeNoise() {
		return "Miaw!";
	}
}
