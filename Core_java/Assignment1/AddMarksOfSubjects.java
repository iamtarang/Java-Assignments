package Assignment1;

public class AddMarksOfSubjects {
	public static void main(String[] args) {

		if (args.length != 0) {
			System.out.println(summation(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
		} else {
			int subject1 = 23;
			int subject2 = 50;
			System.out.println(summation(subject1, subject2));
		}

	}

	public static int summation(int subject1, int subject2) {
		return subject1 + subject2;
	}
}