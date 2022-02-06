
public class Microwave {
	
	public double timer = 60;
	public String mode;
	
	public static void main(String[] args) {
		String mode = "test";

		Microwave mic = new Microwave();
		
		mic.start(20);
		mic.changeMode("Popcorn");

	}
	public Microwave() {
	}
	
	public Boolean start(int duration) { return false; }
	
	public Boolean changeMode(String mode) { return false; }
	
	public void toggleLight() {}
	
}
