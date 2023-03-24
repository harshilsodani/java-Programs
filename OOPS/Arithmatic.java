package OOPS;

import java.util.*;

public class Arithmatic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the real part of the first complex number: ");
        int real1 = sc.nextInt();

        System.out.print("Enter the imaginary part of the first complex number: ");
        int imag1 = sc.nextInt();

        System.out.print("Enter the real part of the second complex number: ");
        int real2 = sc.nextInt();

        System.out.print("Enter the imaginary part of the second complex number: ");
        int imag2 = sc.nextInt();

        Complex a = new Complex(real1, imag1);
        Complex b = new Complex(real2, imag2);

        System.out.print("Sum: ");
        Complex c = Complex.add(a, b);
        c.printComplex();

        System.out.print("Difference: ");
        Complex d = Complex.diff(a, b);
        d.printComplex();

        System.out.print("Product: ");
        Complex e = Complex.product(a, b);
        e.printComplex();

        sc.close();
    }

}

class Complex {
    int real;
    int imag;

    Complex(int r, int i) {
        real = r;
        imag = i;
    }

    public static Complex add(Complex a, Complex b) {
        return new Complex((a.real + b.real), (a.imag + b.imag));
    }

    public static Complex diff(Complex a, Complex b) {
        return new Complex((a.real - b.real), (a.imag - b.imag));
    }

    public static Complex product(Complex a, Complex b) {
        return new Complex(((a.real * b.real) - (a.imag * b.imag)), ((a.real * b.imag) + (a.imag * b.real)));
    }

    public void printComplex() {
        if (real == 0 && imag != 0) {
            System.out.println(imag + "i");
        }

        else if (real != 0 && imag == 0) {
            System.out.println(real);
        }

        else {
            System.out.println(real + "+" + imag + "i");
        }
    }
}