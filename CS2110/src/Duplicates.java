import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Duplicates {

	public static void main(String[] args) {
		ArrayList<String> inputList = new ArrayList<String>(); // an ArrayList of Strings "inputList"
		// comment out above and uncomment below if you want to try the array bonus
		// String[] inputList;

		Scanner key = new Scanner(System.in); // create a Scanner ("key") to read in user input
		System.out.println("How many Strings would you like to enter?"); // the prompt
		int num = key.nextInt(); // read the input that was entered by the user, store it in "num"
		key.nextLine();

		// uncomment below if you want to try the array bonus
		// inputList = new String[num];

		// Allow the user to add a String "num" times (based on what they entered above)
		String str;
		for (int i = 0; i < num; i++) { // for loop going around "num" times...
			System.out.println("What String would you like to add?"); // prompt
			str = key.nextLine(); // grab the entered String
			inputList.add(str); // add the string to the ArrayList using the add() method
			// comment out above and uncomment below if you want to try the array bonus
			// inputList[i] = str;

		}

//Print out the input list ("inputList"), then call the method removeDups(),
		// then print
		System.out.println(inputList);
		System.out.println(removeDups(inputList)); // call removeDups method (pass in "inputList")
		// and print out the ArrayList without duplicates

		// comment out above and uncomment below if you want to try the array bonus
		// System.out.println(Arrays.toString(inputList));
		// System.out.println(Arrays.toString(removeDups(inputList)));

	} // END main

	public static ArrayList<String> removeDups(ArrayList<String> input) {
		ArrayList<String> output = new ArrayList<String>();
		for (String item : input) {
			if (output.contains(item)) {
				output = output;
			} else {
				output.add(item);
			}
		}
		return output;
	}

	// YOUR SOLUTION TO THIS IN-CLASS ACTIVITY GOES HERE
	// (Write your solution here - outside of the "main" method!)

}