package Assignment1;

public class Fibonacci {
    public static void main(String[] args) {
        long n1 = 0, n2 = 1;
        long count = 0;

        System.out.println("The first 50 Fibonacci numbers are:");

        while (count < 50) {
            System.out.println(n1);
            long sum = n1 + n2;
            n1 = n2;
            n2 = sum;
            count++;
        }
    }
}