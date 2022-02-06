import static org.junit.Assert.*;

import org.junit.*;
import org.junit.Test;

public class InClass13Test {
	double base;
	int exp;
	
	
	@Before
	public void setup() {
		base = 10.5;
		exp = 2;
		
	}
	@Test
	public void test1() {
		assertTrue(InClass13.power(base, exp) == 110.25);
	}
	@Test
	public void test2() {
		assertTrue(InClass13.power(base, -exp) == 0.009070294784580499);
	}
	@Test
	public void test3() {
		assertFalse(InClass13.power(0, -exp) == 00);
	}
	
}
