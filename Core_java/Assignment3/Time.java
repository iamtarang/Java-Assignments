package Assignment3;

class Hour {
	int hour;

	public Hour(int hour) {
		this.hour = (hour >= 0 && hour < 24) ? hour : 0;
	}

	public int getHour() {
		return hour;
	}
}

class Minutes extends Hour {
	int minutes;

	public Minutes(int hour, int minutes) {
		super(hour);
		this.minutes = (minutes >= 0 && minutes < 60) ? minutes : 0;
	}

	public int getMinutes() {
		return minutes;
	}
}

class Seconds extends Minutes {
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

	@Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minutes, seconds);
    }
}

public class Time {
	public static void main(String[] args) {
		Seconds time1 = new Seconds(10, 30, 45);
		Seconds time2 = new Seconds(15, 45, 20);

		System.out.println("Time 1: " + time1);
		System.out.println("Time 2: " + time2);

		Seconds difference = time1.timeDifference(time2);
		System.out.println("Time difference: " + difference);
	}
}
