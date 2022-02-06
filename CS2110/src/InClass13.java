/**
 * In class activity. Write 3 JUnit tests to get 100% statement coverage
 *
 */
public class InClass13 {
	public static double power(double base, int exp) {
		boolean negExp = (exp <= 0);
		if (base == 0 && negExp) {
			return Double.NaN;
		}
		exp = Math.abs(exp);
		double product = 1;
		while (exp > 0) {
			product *= base;
			exp--;
		} 
		if (negExp) {
			return 1 / product;
		} else {
			return product;
		}
	}
	
}
