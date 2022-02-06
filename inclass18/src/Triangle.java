/**
 * Abstract class demonstration:
 * 
 * Triangle class defines the method and fields that Right and Equilateral share:
 * 3 sides and the perimter method.
 * 
 * We calculate area differently in both cases, so we define area as abstract, 
 * meaning it's up to the child class to define this behavior.
 * 
 * @author Will
 *
 */
public abstract class Triangle {
	protected double sideA, sideB, sideC;
	
	/**
	 * Constructor simply takes in three sides and assigns then to A, B, and C
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 */
	public Triangle(double sideA, double sideB, double sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}
	
	/**
	 * Perimeter is just the sum of the sides
	 * @return perimeter.
	 */
	public double perimeter() {
		return sideA + sideB + sideC;
	}
	
	/**
	 * Area is "hard" to calculate from the three sides, so we'll make the sub classes responsible
	 * for implementing this behavior.
	 */
	public abstract double area();
	
	public String toString() {
		return "SideA: " + sideA + ", SideB: " + sideB + ", SideC: " + sideC;
	}
}
