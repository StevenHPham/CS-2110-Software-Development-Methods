import java.util.Random;

public class Review1_DataTypes {

	public static void main(String[] args) {
		
		// *** Character Example 
		char CapitalC = 'C';
		System.out.println((int)CapitalC); // cast char into an int
		char ch = 'a';
		int cIntVal = (int)ch; // cast the char c into an int, result in cIntVal
		System.out.println("Integer value of char ch ('" + ch + "'): " + cIntVal);
		System.out.println("The character associated with code '97' is: "+(char)97);
		
		// If 'a' = 97, then 97+6 will be 'g'
		System.out.println((char)(99)); // OUTPUT: g
		System.out.println((char)104);
		
		// Printing "hi" ...
		System.out.print((char)104);
		System.out.println((char)105);
		System.out.println("----------------------");
		//System.out.println('a' + (String)CapitalC); // Error: Cannot cast from char to String (doesn't work)
		System.out.println('a' + CapitalC); // converts to ASCII and does the 'math'! 
		System.out.println("----------------------");
		//===========================================



		// *** Double Example
		System.out.println(0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1);
		// 10 * 0.1 should be 1.0   HOWEVER, it is 0.9999999999999999 !
		// Better to store dollars separately and cents separately and update
		// as necessary. Same with time: store hours, minutes, and seconds separately
		System.out.println("----------------------");
		//===========================================



		// *** Casting Example
		// When converting Higher --> Low, need to cast the type
		// double is a higher ranking than int
		double d = 208.4; 
		int i = 2;
		//int res = d / i; // error - Java won't automatically cast (High -> Low) [uncomment this line to see error]
		double res = d / i; // now this is OK
		System.out.println(res); // OUTPUT: 104.2
		int res2 = (int) (d / i); // Need to cast due to information loss
		System.out.println(res2); // OUTPUT: 104
		System.out.println("----------------------");
		//===========================================

		

		// *** Random Example - example of reference type
		Random randomGenerator = new Random(); // using key-word new
		int randomInt = randomGenerator.nextInt(25); // Random number 0-25 (calling method nextInt())
		System.out.println(randomInt);
		System.out.println("----------------------");
		//===========================================	

		

		// *** String Example
		String word = "House";
		//word = "somethingelse"; //!
		System.out.println(word);
		// House --> Mouse
		System.out.println(word.replace('H', 'M')); // Replace 'H' with 'M' -> Mouse; using method replace
		// wow --> pop
		String word2 = "wow";
		System.out.println(word2 + " becomes " + word2.replace('w', 'p'));
		System.out.println("Original word remained unchanged: " + word2);
		
		System.out.println(word2 + " becomes " + word2.replaceFirst("w", "p")); // POW!; using replaceFirst()
		System.out.println("----------------------");
		//===========================================	



		// *** Integer Division	
		int x = 1, y = 3;
		int res3 = x / y;
		// OUTPUT: 0 (zero!)
		System.out.println("Integer division: " + x + "/" + y + " = " + res3);
		//Cast one of them for non-integer division:
		System.out.println("Now not equal to zero: " + (double)x / y);
		double r4 = (double)x/y;
		System.out.println(r4);
		System.out.println("----------------------");
		//===========================================


	}

}
