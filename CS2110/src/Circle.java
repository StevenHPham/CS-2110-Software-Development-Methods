
public class Circle {
	
	//fields
	private double radius;
	private Point center;
	
	//constructors (name is same as class)
	public Circle() {
		//to initialize my field.. making radius and center PUBLIC
		this.radius = 1.0;
		this.center = new Point(0.0,0.0);
		
	}
	
	public Circle(double rad, Point c) {
		this.radius = rad;
		this.center = new Point(c);
	}

	public String toString() { //return console message
		return "Center: " + this.center + " Radius: " + this.radius;
	}

	public static void main(String[] args) {//creating my circle
		Circle c = new Circle();
		Point p = new Point(0.5,0.5);
		Circle c2 = new Circle(3.0,p);
		Circle c3 = new Circle(3.0, p);
		System.out.println(c2.equals(c)); 
		System.out.println(c2.equals("hello")); //null check
		System.out.println(c2.equals(c3)); 
		System.out.println(c.equals(c3));
		
		

	}

	public double getRadius() {
		return this.radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Point getCenter() {
		return this.center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	public boolean equals(Object other) {
		if (other == null) { //null check (if input creates null, return false) null means wrong the type of data
			return false;
		}
		if (other instanceof Circle) { //if other is a point... 
			Circle c2 = (Circle) other; //typecasting - put on your Point hat so I can ask you question about the point data type
			//if x cord == y cord then true
			return (this.radius == c2.radius) && (this.center.equals(c2.getCenter()));
			
		}
		else {
			return false; //This is telling me that other is not a point.
		}
	}
}
