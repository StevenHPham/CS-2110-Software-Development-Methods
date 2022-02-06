
public class AlarmClock extends Clock {
	private int alarmHour, alarmMinute;
	//Constructors
	/**
	 * This creates an alarm clock set to the current time
	 * @param brandName
	 * @param alarmHour
	 * @param alarmMinute
	 */
	public AlarmClock(String brandName, int alarmHour, int alarmMinute) {
		super(brandName); //use this to pass brandName to the parent class, and create the parent Clock instance
		this.alarmHour = alarmHour;
		this.alarmMinute = alarmMinute;
	}
	/**
	 * This creates an alarm clock set to a custom time
	 * @param brandName
	 * @param alarmHour
	 * @param alarmMinute
	 */
	public AlarmClock(String brandName, int alarmHour, int alarmMinute, int hour, int minute, int second, boolean isPM) {
		super(brandName, hour, minute, second, isPM); //create the parent instance by passing relevant information.
		this.alarmHour = alarmHour;
		this.alarmMinute = alarmMinute;
	}
	
	//Getters
	public int getAlarmHour() {
		return alarmHour;
	}
	
	public int getAlarmMinute() {
		return alarmMinute;
	}
	//Setters - triggers alarm if alarm set to current time.
	public void setAlarmHour(int alarmHour) {
		this.alarmHour = alarmHour;
		checkAlarm();
	}
	
	public void setAlarmMinute(int alarmMinute) {
		this.alarmMinute = alarmMinute;
		checkAlarm();
	}
	//Update clock to current time, and trigger alarm if needed.
	public void update() {
		super.update();
		checkAlarm();
	}
	//Prints BEEP BEEP BEEP BEEP BEEP if alarm should go off.
	private void checkAlarm() {
		if (hour == alarmHour && minute == alarmMinute) {
			System.out.println("BEEEP BEEP BEEEP BEEP BEEP");
		}
	}
	
	public String toString() {
		checkAlarm();
		String s = brandName + " brand alarm clock " + getTimeAsString(); //don't need super because no overriding method
		return s + "\n\tAlarm: " + hour + ":" + minute + (isPM ? "p.m." : "a.m.");
	}
	
	public static void main(String[] args) {
		AlarmClock ac = new AlarmClock("Cassio", 0, 6);
		System.out.println(ac);
		System.out.println(ac.getHour()); //can call parent class method
		System.out.println(ac.getAlarmHour()); //can call child class method
		Clock c = new AlarmClock("Digitech", 12, 00); //substitution principle
		System.out.println(c); //still prints like an alarm clock
		System.out.println(c.getHour()); //can call parent class method
		//System.out.println(c.getAlarmHour()); //CANNOT call child class method, because type is currently Clock, not AlarmClock
		System.out.println(((AlarmClock) c).getAlarmHour()); //can dynamically typecast and then call it
		
		//AlarmClock c = new Clock("I'm out of name ideas"); //does not compile, subsitution principle doesn't work that way.
	}
}
