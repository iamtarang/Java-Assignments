package Assignment4.time;

public class Hour {
	int hour;

	public Hour(int hour) {
		this.hour = (hour >= 0 && hour < 24) ? hour : 0;
	}

	public int getHour() {
		return hour;
	}
}
