package Assignment1;

public class RandomString {
	public static void main(String[] args) {
		char[] alphabet = { 'A', 'B', 'C', 'D' };
		int stringLength = 10;
		
		String randomString = generateRandomString(alphabet, stringLength);
		System.out.println("Generated Random String: " + randomString);
	}

	public static String generateRandomString(char[] alphabet, int length) {
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int randomIndex = (int) (Math.random() * alphabet.length);
			sb.append(alphabet[randomIndex]);
		}

		return sb.toString();
	}
}
