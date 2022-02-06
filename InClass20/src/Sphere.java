
public class Sphere implements Solids {
	
	private double radius;
	private String  color;
	private String name;
	
	public Sphere(double radius, String color, String name){
		this.radius = radius;
		this.color = color;
		this.name = name;
		
	}
	
	//Volume = 4/3*pi*r^3
	public double getVolume(){
		return 4/3*Math.PI * radius * radius * radius;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
	
	
}
