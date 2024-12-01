package Assignment2;

public class ComplexNumber {

    int real, image;

    public ComplexNumber(int r, int i) {
        this.real = r;
        this.image = i;
    }

    // function to print real number
    public void showAns() {
        System.out.print(this.real + " + " + this.image + "i");
    }

    // function for addition
    public static ComplexNumber add(ComplexNumber n1, ComplexNumber n2) {

        // creating blank complex number
        // to store result
        ComplexNumber res = new ComplexNumber(0, 0);

        // adding real parts of both complex numbers
        res.real = n1.real + n2.real;

        // adding imaginary parts
        res.image = n1.image + n2.image;

        // returning result
        return res;
    }

    public static void main(String arg[]) {

        // creating two complex numbers
        ComplexNumber c1 = new ComplexNumber(4, 5);
        ComplexNumber c2 = new ComplexNumber(10, 5);

        // printing complex numbers
        System.out.print("First Complex number: ");
        c1.showAns();

        System.out.print("\nSecond Complex number: ");
        c2.showAns();

        // calling add() to perform addition
        ComplexNumber res = add(c1, c2);

        // displaying addition
        System.out.println("\nAddition is :");
        res.showAns();
    }
}
