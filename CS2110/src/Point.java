
public class Point {
	
	private double x;
	private double y;
	
	public static void main(String[] args) {
		Point p1 = new Point(3.0,2.5);
		Point p2 = new Point();
		System.out.println(p1);
		System.out.println(p2);
				
	}
	public Point() { //default constructor
		this.x = 0.0; // default value
		this.y = 0.0;
	}
	
	//COPY CONSTRUCTOR
	public Point(Point p2) {
		this.x = p2.x;
		this.y = p2.y;
	}
	
	
	public double distance(Point p) {
		double xdiff = this.x - p.x;
		double ydiff = this.y - p.y;
		return Math.sqrt(xdiff*xdiff + ydiff + ydiff);
		
	}
	//How to write an equals method
	public boolean equals(Object other) {
		if (other == null) { //null check (if input creates null, return false) null means wrong the type of data
			return false;
		}
		if (other instanceof Point) { //if other is a point... 
			Point comparePoint = (Point) other; //typecasting - put on your Point hat so I can ask you question about the point data type
			//if x cord == y cord then true
			return (this.x == comparePoint.x) && (this.y == comparePoint.y);
			
		}
		else {
			return false; //This is telling me that other is not a point.
		}
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return("(" + this.x + ", " + this.y + ")");
	}
	public double getX() {
		return this.x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return this.y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	
}
