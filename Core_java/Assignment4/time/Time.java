package Assignment4.time;

public class Time {
	public static void main(String[] args) {
		Seconds time1 = new Seconds(10, 30, 45);
		Seconds time2 = new Seconds(15, 45, 20);

		System.out.println("Time 1: " + time1.toString());
		System.out.println("Time 2: " + time2.toString());

		Seconds difference = time1.timeDifference(time2);
		System.out.println("Time difference: " + difference.toString());
	}
}
