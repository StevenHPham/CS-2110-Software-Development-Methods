/*
 * REVIEW -- Array vs ArrayList
 * 
 * The goal of this file is to highlight the differences between Arrays and ArrayLists
 */

// [1] - Import Statement //
import java.util.ArrayList; // ArrayList NEEDS this import statement
import java.util.Arrays;    // Array does NOT need an import stmt, but this one helps with printing
							// See line 44 below 

public class Review5_ArrayVsArrayList {

	public static void main(String[] args) {
		// [2] Creating an Array vs an ArrayList //
		int[] arr = new int[3]; // .. Array .. // Need to specify size (here: size=3)
		ArrayList<Integer> arrL = new ArrayList<Integer>(3); // .. ArrayList .. // Size NOT needed
		ArrayList<Integer> arrL2 = new ArrayList<Integer>();
		
		// [3] Data //
		// Arrays can only hold one kind of data type
		// It is possible for ArrayLists to hold differing data types
		// Note for ArrayList, the Object Integer (see ArrayList Object Types PDF for more info!)
		
		// [4] Adding elements //
		// .. Array ..
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3; 
		//arr[3] = 4; // CANNOT do; size cannot change (grow or shrink)
		
		// .. ArrayList ..
		arrL.add(10); // note: the method add() is used
		arrL.add(50);
		arrL.add(70);
		arrL.add(80); // CAN do this; CAN expand beyond initial stated capacity of 3 (in this ex) 
		
		// [5] Accessing specific element //
		System.out.println(arr[0]); 		// get first Array element - use square brackets
		System.out.println(arrL.get(0));	// get first ArrayList element - use get() method 
		
		// [6] What is the "size" of the data structure? //
		// .. ArrayList .. // size() method
		System.out.println("ArrayList: " + arrL + " Size: " + arrL.size()); 
		// .. Array .. // length attribute
		System.out.println("Array: " + Arrays.toString(arr) + " Size: " + arr.length); 
		// Also remember the IMPORT statement? Here it is used to help print the Array
		
		// [7] ArrayList has many helpful methods... // contains() // indexOf() // ...more! // 
		System.out.println("Does the ArrayList contain '30'? " + arrL.contains(30)); //true or false
		System.out.println("Index position of '70' is: " + arrL.indexOf(70)); // -1 if not there
		System.out.println(""); // adding an extra line between extra example output 
		
		
		// ********* Extra Example using Loops *********
		// In addition: use of .equals() method for comparing Strings
		ArrayList<String> arrLofStrings = new ArrayList<String>();
		arrLofStrings.add("hello"); 
		arrLofStrings.add("bonjour");
		arrLofStrings.add("konnichiwa");
		arrLofStrings.add("ciao"); 
		arrLofStrings.add("salaam"); 
		arrLofStrings.add("ni hao"); 
		arrLofStrings.add("namaste");
		arrLofStrings.add("hola"); 
		
		String searchTerm = "bonjour"; 
		boolean isFound = false;
		for (String item : arrLofStrings) {
			if (item.equals(searchTerm)) { // is the current item equal to the searchTerm?
				isFound = true; // found it!
			}
		}
		
		if(isFound) {
			System.out.print(searchTerm + " is in the dictionary!");
		}
		else
			System.out.print(searchTerm + " is NOT in the dictionary!");
		// *********
		// Question is there another way to search for an item in an ArrayList without looping?
		// *********
		
	} // END main
	
	// Using an ArrayList as a return data type in a method:  public static ArrayList<Sting> stuff ()
	// Passing an ArrayList as a parameter to a method:  ..... (ArrayList<Integer> n1)	

} // END Class