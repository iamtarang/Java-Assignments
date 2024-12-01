package Assignment4.time;

public class Seconds extends Minutes {
	int seconds;

	public Seconds(int hour, int minutes, int seconds) {
		super(hour, minutes);
		this.seconds = (seconds >= 0 && seconds < 60) ? seconds : 0;
	}

	public int getSeconds() {
		return seconds;
	}

	public Seconds timeDifference(Seconds other) {
		int totalSeconds1 = this.hour * 3600 + this.minutes * 60 + this.seconds;
		int totalSeconds2 = other.hour * 3600 + other.minutes * 60 + other.seconds;
		int diffSeconds = Math.abs(totalSeconds1 - totalSeconds2);

		int hours = diffSeconds / 3600;
		int minutes = (diffSeconds % 3600) / 60;
		int seconds = diffSeconds % 60;

		return new Seconds(hours, minutes, seconds);
	}

}