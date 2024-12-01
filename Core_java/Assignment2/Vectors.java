package Assignment2;

public class Vectors {
	int x, y, z;

	public Vectors(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void displayVector() {
		System.out.println("x: " + this.x + ", y: " + this.y + ", z: " + this.z);
	}

	public static Vectors addVectors(Vectors v1, Vectors v2) {
		Vectors resVector = new Vectors(0, 0, 0);

		resVector.x = v1.x + v2.x;
		resVector.y = v1.y + v2.y;
		resVector.z = v1.z + v2.z;

		return resVector;
	}

	public static void main(String[] args) {
		Vectors v1 = new Vectors(43, 22, -13);
		Vectors v2 = new Vectors(-39, 83, -74);

		System.out.println("First Vector: ");
		v1.displayVector();

		System.out.println("Second Vector: ");
		v2.displayVector();
		
		Vectors ans = addVectors(v1, v2);
		System.out.println("\nAfter addition Vector: ");
		ans.displayVector();
	}
}
