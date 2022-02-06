import static org.junit.Assert.*;

import org.junit.*;


public class TaxiTest {
	
	Taxi t;
	double rate = 12.00;
	
	@Before
	public void setup() {
		t = new Taxi(rate, 5);
	}

    //Sample Unit Test
    @Test(timeout=100)
    public void testPickUpSuccess() {
        assertTrue(t.pickUp(5));
    }
    
    //calculateFare() test
    @Test(timeout=100)
    public void testCalculateFare() {
    	int passengersLoading = 4;
    	int duration = 100;
    	
    	t.pickUp(passengersLoading);
        double fare = t.calculateFare(passengersLoading, duration);
        
        assertTrue(fare == passengersLoading * duration * rate);
    }
    
    //pickUp() test #1
    @Test(timeout=100)
    public void testPickUpEnoughRoom() {
        assertTrue(t.pickUp(3));
    }
    
    //pickUp() test #2
    public void testPickUpFail() {
    	assertFalse(t.pickUp(6));
    }
}
