import java.util.*;
import java.util.Map;

/* Starter Code for Maps in-class activity */

public class MapsInClass {

    public static void main(String[] args) {
        TreeMap<String, Integer> phoneBook = new TreeMap<String, Integer>();
        phoneBook.put("Lorna", 321);
        phoneBook.put("Anna", 456);
        phoneBook.put("Grace", 789);
        phoneBook.put("Clayton", 115);
        System.out.println(reverseBook(phoneBook));
        System.out.println(phoneBook);
        // Output should be:  {115=Clayton, 321=Lorna, 456=Anna, 789=Grace}

    } // END main
    
	
    // reverseBook method that takes in a TreeMap phoneBook (<String, Integer>)
    // and returns another TreeMap that is the reverse of phoneBook (<Integer, String>).
    // That is, the key for phoneBook becomes the value for the new TreeMap, and the value for 
    // phoneBook becomes the key for the new TreeMap.
    
    public static TreeMap<Integer,String> reverseBook(TreeMap<String,Integer> phoneBook){
    	TreeMap<Integer,String> reverse = new TreeMap<Integer,String>();
    	for (String s: phoneBook.keySet()) {
    		reverse.put(phoneBook.get(s), s);
    		System.out.println(phoneBook.get(s));
    	}
    	return reverse;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public static TreeMap<Integer, String> reverseBook(TreeMap<String, Integer> phoneBook) {
//    	TreeMap<Integer, String> reversePhoneBook = new TreeMap<Integer, String>();
//    	for(String s: phoneBook.keySet()) {
//        	reversePhoneBook.put(phoneBook.get(s),s);
//        	
//        }
//		return reversePhoneBook;
//		
//		
//		
//    }

} // END class 
