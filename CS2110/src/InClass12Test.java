import static org.junit.Assert.*;

import org.junit.Test;

public class InClass12Test {
	//this is mandatory "@Test", always public and void
	@Test
	public void testFail() {
		//fail("Not yet implemented");
		
		//input
		int[] arr;
		arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		int k     = 2;
		//expected
		int expectedFail = 2;
		
		//actual
		int actual = InClass12.getMinimumIndexAfter(arr, k);
		
		assertEquals(expectedFail, actual);
	}
	@Test
	public void testPass() {
		//fail("Not yet implemented");
		
		//input
		int[] arr;
		arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		int k     = 2;
		//expected
		
		int expectedPass = 0;
		//actual
		int actual = InClass12.getMinimumIndexAfter(arr, k);
		
		assertEquals(expectedPass, actual);
		
	}
}


