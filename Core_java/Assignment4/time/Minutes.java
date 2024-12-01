package Assignment4.time;

public class Minutes extends Hour {
	int minutes;

	public Minutes(int hour, int minutes) {
		super(hour);
		this.minutes = (minutes >= 0 && minutes < 60) ? minutes : 0;
	}

	public int getMinutes() {
		return minutes;
	}
}
