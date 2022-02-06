import java.util.Arrays; //used to facilitate printing out an array (see example below) 

public class Review3_1DArray {

	public static void main(String[] args) {

		// 1D Array Examples 
		
		// Declaring an array -- reference to the array
		int[] intArray;
		String[] cityNames;
		
		// Instantiating an array (remember Java key-word "new"!)
		intArray = new int[10]; // size=10
		
		// Note: once an array is created its size cannot change
		

		// Declaring and Instantiating at the same time
		int[] nums = new int[4];
		
		
		

		// Adding values to the Array data structure
		nums[0] = 87;
		nums[1] = 77;
		nums[2] = 25;
		nums[3] = 100;
		
		// What happens?
		// nums[4] = 200;  ---> ERROR!
		// ArrayIndexOutOfBoundsException -see this when you try to run the program.
		
		// ===============================================================

		// Can do math-like things (provided an �int� array�)
		nums[0] = 4 * nums[2] + 1;
		int i = 3;
		nums[1] = 89;
		

		// Declare, Instantiate, and "load the array" initialize
		double[] rate = new double[] {10.4, 3.9, 6.2}; // size=3
		double[] rates = {10.5, 2.8, 34.9}; // used the most
		
		// ===============================================================		

		// Loops and Arrays
		for(int x = 0; x<4; x++) {
			System.out.println("x = " + x + " : " + nums[x]);
		}
		
		// ===============================================================		
		
		// Use of Arrays (special class)
		System.out.println("Using 'Arrays' to print 'rates' array: " + Arrays.toString(rates));
		
		// ===============================================================
		
		// Finding duplicates
		String[] names = {"Karina", "George", "Sara", "Kim", "George", "Ashley"};
		
		boolean dup = false;
		String dupname = ""; // initialize the String variable to the empty string
		
		for(int a=0; a < names.length-1; a++) {   // the field "length" is used for arrays to know the size
		    for(int b=a+1; b < names.length; b++) {
		        if(names[a].equals(names[b])) {
		            dup = true;
		            dupname = names[a]; // save the duplicate name in "dupname" String variable (print it out later)
		        }
		    }
		}
		if(dup) {
		    System.out.println("I found a duplicate! The duplicate name was: " + dupname);
		}
		else {
		    System.out.println("There were no duplicates!");
		}
		
		
		// ===============================================================
		
		// Example: Average of 100 doubles
		double[] numbers = new double[100];
		// Load the array with doubles:
		for(int q = 0; q < numbers.length; q++) { // < size of numbers
			numbers[q] = 10 * Math.random();
		}
		// "size" is the "length" field (it's not a method)
		System.out.println("Array length is: " + numbers.length);
		
		// Sum all the values in the numbers array:
		double sum = 0.0;
		for(int p = 0; p < numbers.length; p++) {
			sum += numbers[p]; 
		}

		// Calculate the average:
		System.out.println("The avg is: " + sum / numbers.length);
		

		// Example of a for-each loop
		int[] myArray = new int[5];
		myArray[0] = 9;
		myArray[1] = 8;
		myArray[2] = 7;
		myArray[3] = 6;
		myArray[4] = 5;
		for(int theInt : myArray) {
			System.out.println(theInt); 
			// can do whatever you want with theInt
			// however, notice you no longer have access to indicies!
		}
		
		// ===============================================================		
		
		// Passing arrays as a parameter (to a method):
		int[] A = {10, 30, 50, 90};
		printArray(A); // call to the method "printArray" passing Array "A" as the parameter 
		
	} // END Main
	

	// printArray method that takes in an Array and prints out the values
	private static void printArray(int[] Arr) {
		// Print the array using a for-each loop
		System.out.println("Printing from method printArray");
		for(int ele : Arr) {
			System.out.print(ele + " ");  // notice, the use of print rather than println (no new line included)
		}
	} // END printArray
		

}

