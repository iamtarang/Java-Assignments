package Assignment1;

import java.math.BigInteger;

public class FactorialOf50 {
    public static void main(String[] args) {
        int num = 50;
        System.out.println(factorialFun(num));
    }

    static BigInteger factorialFun(int num) {
        if (num <= 1) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(num).multiply(factorialFun(num - 1));
        }
    }
}