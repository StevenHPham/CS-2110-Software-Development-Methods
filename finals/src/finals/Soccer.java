package finals;

import java.util.ArrayList;

public class Soccer extends Sport {
    final int players = 11;
   
    public Soccer() {
          super("Soccer", true, 10.2);
    }
   
    public String toString() {
          return this.getName() + " played with " + players + " players";
    }
   
    public String getSuperString() {
          return super.toString();
    }
    
    public static void main(String[] args)
    {
  	  ArrayList<Sport> sp2 = new ArrayList<Sport>();
  	  sp2.add(new Soccer());
  	  System.out.println(sp2.get(0).toString());
  	  System.out.println(sp2.get(0).getSuperString());
    }
}

