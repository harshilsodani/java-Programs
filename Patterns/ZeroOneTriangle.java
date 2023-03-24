package Patterns;

public class ZeroOneTriangle {
    public static void main(String[] args) {
        zero_one_triangle(10);
    }

    // ZERO ONE TIRANGLE
    public static void zero_one_triangle(int totRows) {

        // outer loop(rows)
        for (int i = 1; i <= totRows; i++) {

            // inner loops(columns)
            for (int j = 1; j <= i; j++) {
                int sum = i + j;
                if (sum % 2 == 0) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }

            System.out.println();
        }
    }
}
