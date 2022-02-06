import java.util.*;

public class test {

	public static void main(String[] args) {
		ArrayList num1 = new ArrayList();
		int data;
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
		    data = in.nextInt();
		    num1.add(data);
		    if (data == 0 && num1.size() > 3) {
		        num1.remove(num1.size() - 1);
		    }
		}
	​​​​​​​System.out.println("size is : " +num1.size() );

	}

}
