
public class inclass5 {

	public static void main(String[] args) {
		double aa = 1.0;
		double bb = 4.2;
		double res = points(aa,bb);
		System.out.println(res);
		
		double a = -4.2;
		double b = 1.0;
		double res1 = points(a,b);
		System.out.println(res1);
		
		double c = -1.0;
		double d = -4.2;
		double res2 = points(c,d);
		System.out.println(res2);
		
		
		double e = 10;
		double f = -42;
		double res3 = points(e,f);
		System.out.println(res3);
		
		double ee = 0;
		double ff = 0;
		double res4 = points(ee,ff);
		System.out.println(res4);
	
	}

	public static double points (double x, double y) {
		if (x > 0 && y > 0) 
			return x * y;
	
		if (x < 0 && y >= 0) 
			return x - y;
		
		if ( x < 0 && y < 0) 
			return x / y;
		
		else 
			return x + y;
		
			
					
	}
}
