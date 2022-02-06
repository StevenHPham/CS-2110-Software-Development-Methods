/**
 * This child class implements an equilateral triangle
 * @author Will
 *
 */
public class EquilateralTriangle extends Triangle {
	
	/**
	 * We only need on input parameter to constructor, since all three sides are the same
	 * @param sideA
	 */
	public EquilateralTriangle(double sideA) {
		//Every child must first have a parent, so in our constructor the first thing we do is
		//create our parent by calling the parent constructor, using super()
		super(sideA, sideA, sideA);
	}
	
	/**
	 * Area of an equilateral triangle
	 */
	@Override
	public double area() {
		return Math.sqrt(3) * 0.25 * sideA * sideA;
	}

}
