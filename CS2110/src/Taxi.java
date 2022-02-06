//

public class Taxi {
		
    private double rate;
    private int capacity;
    private int passengers;

	public Taxi() { // NO-ARGUMENT CONSTRUCTOR
        this.rate = 1;
        this.capacity = 0;
        this.passengers = 0;
	}
	
	public Taxi(double rate, int capacity) {
        this.rate = rate;
        this.capacity = capacity;
        this.passengers = 0;
	}
	
	public double calculateFare(int passengersLeaving, int durationOfRide) {
        passengers -= passengersLeaving;
        return passengersLeaving * durationOfRide * rate;
	}
	
	public boolean pickUp(int passengersLoading) {
		if (passengersLoading + passengers > capacity) {
			return false;
		} else {
			passengers +=  passengersLoading;
			return true;
		}
	}

}
