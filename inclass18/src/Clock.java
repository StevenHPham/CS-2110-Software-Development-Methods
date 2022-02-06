import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Clock {
	protected String brandName;
	protected int hour, minute, second;
	protected boolean isPM;
	
	public Clock(String brandName) {
		this.brandName = brandName;
		update();
	}
	
	public Clock(String brandName, int hour, int minute, int second, boolean isPM) {
		this.brandName = brandName;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.isPM = isPM;
	}
	
	public void update() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
		String s = dateTime.format(f);
		hour = Integer.parseInt(s.substring(0, 2));
		minute = Integer.parseInt(s.substring(3, 5));
		second = Integer.parseInt(s.substring(6, 8));
		if (hour > 12) {
			hour -= 12;
			isPM = true;
		}
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public int getSecond() {
		return second;
	}
	
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public void setSecond(int second) {
		this.second = second;
	}
	
	public String toString() {
		return brandName + " brand clock - " + getTimeAsString();
	}
	
	protected String getTimeAsString() {
		String out = hour + ":" + minute + ":" + second + " ";
		if (isPM) {
			return out + "p.m.";
		} else {
			return out + "a.m.";
		}
	}
	
	public static void main(String[] args) {
		Clock c = new Clock("Cassio");
		System.out.println(c);
		System.out.println(c.getHour());
		// System.out.println(c.getAlarmHour()); //Not an alarm clock, so I can't call AlarmClock method
	}
}
