// REVIEW - Methods, Pass by Value, Pass by Reference, and String example (unique case)

public class Review4_Methods {

	public static void main(String[] args) {
		// testing minFunc
		int x = 5;
		int y = 0;
		int res = minFunc(x, y); // call to the method
		System.out.println(res);
		
		// testing add3
		int z = 10;
		int res2 = add3(x,y,z);
		System.out.println(res2);
		
		double res3 = add3(2.6, 4.8);
		System.out.println(res3);
		
		// testing iMethod - data type: primitive 
		int i = 25;
		System.out.println("Before: " + i);
		iMethod(i); // method call to iMethod
		System.out.println("After: " + i);
		
		// testing swapMethod 
		// objects and object references (e.g. array) - pass by reference
		int[] myArr1 = {2, 4};
		int[] myArr2 = {3, 6};
		System.out.println("First of each: " + myArr1[0] + " " + myArr2[0]);
		swapMethod(myArr1, myArr2); // method call to swapMethod
		System.out.println("First of each: " + myArr1[0] + " " + myArr2[0]);
		
		// testing sMethod
		// String example - reference type
		// (exception, since String objects are immutable)
		String s = "Java is fun!";
		System.out.println(s);
		sMethod(s); // method call to sMethod
		System.out.println(s);
		// Note:
		// String objects are immutable
		// A method that is passed a reference to a String
		// object CANNOT change the original object!		


	} // END main

	
	// minFunc - minimum of two int values
	public static int minFunc (int n1, int n2) {
		int min; 
		if(n1 > n2) 
			min = n2; // min is n2
		else
			min = n1; // otherwise, min is n1
		
		return min;
	}
	
	// iMethod
	// Example of pass by value
	public static void iMethod (int iTest) {
		iTest = 9;
		System.out.println("Inside iMethod: iTest is: " + iTest);
	}
	
	// swapMethod
	// Example of pass by reference
	public static void swapMethod(int[] myA, int[] myA2) {
		// swap first element of each of the arrays:
		int temp;
		temp = myA[0]; // remember first element is at index position 0 
		myA[0] = myA2[0];
		myA2[0] = temp;
		System.out.println("[inside swapMethod] First of each: " + myA[0] + " " + myA2[0]);
	}
	
	// sMethod
	// Example of how String behaves differently, even though it is a reference type
	public static void sMethod(String sTest) {
		sTest = sTest.substring(8, 11); // take a substring of it
		System.out.println("Inside method sMethod: " + sTest);
	}
		
	// ==============================================================
	// Method overloading example
	// add3 example: note ALL these methods have the SAME name, but DIFFERENT parameters 
	public static int add3 (int a, int b, int c) { // three int parameters
		return a + b + c;
	}

	public static double add3 (double x, double y, double z) { // three double parameters
		return x + y + z;
	}
	
	public static double add3 (double q, double r) { // two double parameters 
		return q + r;
	}	
	// ==============================================================
	
} // END class
