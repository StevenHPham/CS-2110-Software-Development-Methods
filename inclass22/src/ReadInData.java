import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadInData {
	
	
	public static double readData(String fileName) {
		File file = new File(fileName);
		Scanner scan = null;
		double sum = 0;
		try {
			scan = new Scanner(file);
			int numOfValues = Integer.parseInt(scan.nextLine()); // Read in Val for # values
			for(int i = 0; i < numOfValues; i++) { // for-loop to get that many values
				sum += scan.nextDouble(); // add the values together (doubles)
			}
			scan.close();
			return sum; // return the sum of all the values in the file 
			
		}//TODO:  ADD catch statements here! (Replace all "SomeException"s with an appropriate exception
		 //                                   Replace all "Some Output" with an appropriate output message
		catch (FileNotFoundException e) {
		    System.out.println("File Output...");
		}
        catch (NumberFormatException e) {
            System.out.println("Number Output...");
        }       
		catch (InputMismatchException e) {
            System.out.println("Mismatch Output...");
        }
        catch (RuntimeException e) {
            System.out.println("Runtime Output...");
        }
        catch (Exception e) {
            System.out.println("Warehouse Output...");
        }
		finally { // don't forget "finally"! Here we clean up
		    // Clean up, close scanner, etc
		    if(scan != null) {
		        scan.close();
		    }
		    //scan.close(); 
		    return 0.0; // return something
		}	
	}
	
	public static void main(String[] args) {
		System.out.println(readData("Test3.txt"));
		System.out.println(readData("Test2.txt"));
		System.out.println(readData("Text4.txt")); // notice spelling of the file name! 
		System.out.println(readData("Test4.txt"));
	}

}
