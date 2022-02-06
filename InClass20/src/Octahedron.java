
public class Octahedron implements Solids{
	
	private double edge;
	private String color;
	private String name;
	
	public Octahedron(double edge , String color, String  name){
		this.edge = edge;
		this.color = color;
		this.name = name;
	}
	
	//Volume sqrt(2)/3 times edge^3
	public double getVolume(){
		return Math.sqrt(2) / 3 * edge * edge * edge;
	}

	public String getColor() {
		return color;
	}

	public String getName() {
		return name;
	}
	
	
}
