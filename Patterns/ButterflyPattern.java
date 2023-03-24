package Patterns;

public class ButterflyPattern {
    public static void main(String[] args) {
        butterfly_pattern(5);
    }

    // BUTTERFLY PATTERN
    public static void butterfly_pattern(int n) {

        // 1st half
        for (int i = 1; i <= n; i++) {

            // i stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // 2*(n-i) spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            // i stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 2nd half
        for (int i = n; i >= 1; i--) {

            // i stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // 2*(n-i) spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            // i stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
