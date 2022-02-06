
public class RightTriangle extends Triangle {
	public static final double ANGLE_C = Math.PI / 4;
	protected double angleA, angleB;
	/**
	 * Constructor takes in the two smaller sides and calculates the hypontenuese
	 * @param sideA - the side opposite angleA
	 * @param sideB - the side opposite angleB
	 */
	public RightTriangle(double sideA, double sideB) {
		//The FIRST thing we must do is call super. Any calculations beforehand must
		//be done before
		super(sideA, sideB, calculateHypotenuese(sideA, sideB));
		angleA = Math.asin(sideA/sideC); //side C is accessible from the parent class
		angleB = Math.asin(sideB/sideC); //side C is accessible from the parent class
	}

	//private static helper method, these are the only things you can use inside of super.
	private static double calculateHypotenuese(double sideA, double sideB) {
		return Math.sqrt(sideA * sideA + sideB * sideB);
	}

	@Override
	public double area() {
		return 0.5 * sideA * sideB;
	}

}
