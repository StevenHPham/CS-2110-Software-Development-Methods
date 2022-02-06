
/**
 * Homework 5
 * 
 * Implement the following methods on recursion
 * as defined in the homework 5 document.
 * 
 * @author shp4df
 *
 */
public class Recursion {
    
    public static boolean palindrome(String s) {
        /**
         * if the length of the string is 1 or 0 , return true
         */
        if (s.length() == 1 || s.length() == 0) {
            return true;
        } else if (s.charAt(0) == s.charAt(s.length()-1)){ 
            
            /**
             compares the first character and last character of the string
             if same character, recursively repeat using a substring with the first and
             last character removed
             */   
            
            return palindrome(s.substring(1,s.length()-1));
        }
      
        return false;
    }
    
    public static String reverseString(String s) {
        if (s.length() == 0) {
            return s;
        } 
        return reverseString(s.substring(1)) + s.charAt(0);
    }
    
    public static int handshakes(int n) {
        if (n <= 0) {
            return 0;
        }
        return handshakes(n-1)+ (n-1) ;
    }    
    
    public static long ackermann(long m, long n) {
        if (m == 0) {
            return n + 1;
        } if (n == 0) {
            return ackermann( m-1  ,  1 );
        }
        return ackermann( m-1  ,  ackermann(m , (n-1) ));
    }
    


    public static void main(String[] args) {
        // write your tests here
        
        /**
         * palindrome test output:
         * true
         * false
         */
        System.out.println(palindrome("racecar"));
        System.out.println(palindrome("race"));
        
        /**
         * reverseString test output:
         * 0112SC
         * racecar
         */
        System.out.println(reverseString("CS2110"));
        System.out.println(reverseString("racecar"));
        
        /**
         * handshakes test output:
         * 3
         * 15
         */
        System.out.println(handshakes(3));
        System.out.println(handshakes(6));
        
        System.out.println(ackermann(0,0));
        System.out.println(ackermann(2,0));
        System.out.println(ackermann(3,4));

    }
}