
public class Rectangle {
	
	// fields
	private double length;
	private double width;
	
	// default constructor (takes no parameters)
	public Rectangle() {
		// length and width assigned default values (1 in  this case)
		this.length = 1;
		this.width = 1;
	}
	
	// constructor 
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	//Write an appropriate 
	//     (1) toString method
	//     (2) getter and setter methods for the length field
	//     (3) getter and setter methods for the width field 
	
	
	public static void main(String[] args) {
		// Reminder: don't write methods within other methods.
		// Test out toString() method and getters and setters here! (Main method testing) 
		Rectangle p1 = new Rectangle(3.0,2.5);
		Rectangle p2 = new Rectangle();
		System.out.println(p1);
		System.out.println(p2);
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	public String toString() {
		return("(" + this.length + ", " + this.width + ")");

	}
}
