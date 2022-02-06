
public class Review2_ControlStructures {
	public static void main(String[] args) {
		// if example ====================================================
		int grade = 82;  // change this value to see various outputs
		
		if (grade > 90) {
			System.out.println("Letter Grade: A");
		}
		else if (grade > 80) {
			System.out.println("Letter Grade: B");
		}
		else if (grade > 70 && grade > 60) {  // ex of AND
			System.out.println("Letter Grade: C");
		}
		else
			System.out.println("fail");
		
		if (grade == 82) {
			System.out.print("Great!");
		    System.out.println(" You got a B");
		}
		
		// while loop example ============================================
		int i = 0;
		while (i <= 5) { // while (conditional statement)
			System.out.println("The value is: " + i);
			i++; // this means   i = i + 1;
		}
		
		// for loop example ===========x`===================================
		for (int q = 0; q<5; q++){ // loop control variable; conditional statement; increment
			// body
			System.out.println(q);
		}
		
		// for each loop (with array ex) =================================
		// array of Strings
		String[] foods = {"steak", "eggs", "cheese"}; 

		// food has to be of the same type as foods
		for (String food : foods ) { // for each element in 'foods' store in variable 'food'
			System.out.println("I like to eat: " + food); // with each iteration a new value is placed in 'food'
		}	
		
	} // END main
} // END class
