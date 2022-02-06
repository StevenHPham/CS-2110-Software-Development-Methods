import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Lab1Scanner_Pham {

	public static void main(String[] args) throws Throwable {
//Activity 1:	
//		System.out.println("Enter 5 intergers: ");
//		Scanner input = new Scanner(System.in);
//		double sum = 0;
//		
//		for (int x = 0; x <5; x++) {
//			sum = sum+input.nextDouble();
//		}
//		
//		double r = sum / 4;
//		System.out.println("The average is" + r);
		
//Activity 2:
		File theFile = new File("data1.txt");
		Scanner fileScnr = new Scanner(theFile);
		String text = "";
		while ( fileScnr.hasNext()) {
			text += fileScnr.nextLine();
			
		}
		System.out.println(text);
		System.out.println(text.length());
		File file = new File("Lab1Scanner_Pham");
		String path = file.getAbsolutePath();
		System.out.println(path);
	}

}
