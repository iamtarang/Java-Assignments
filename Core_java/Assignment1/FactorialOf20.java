package Assignment1;

public class FactorialOf20 {
	public static void main(String[] args) {
		int num = 20;
		long factorial = 1;
		while(num != 1){
			factorial*=num;
			num--;
		}

		System.out.println(factorial);
	}
}
