package Patterns;

public class InvAndRotHalfPyra {
    public static void main(String[] args) {
        inverted_rotated_half_pyramid(10);
    }

    // INVERTED AND ROTATED HALF PYRAMID
    public static void inverted_rotated_half_pyramid(int totRows) {
        // outer loop(Rows)
        for (int i = 1; i <= totRows; i++) {

            // inner loop(columns)
            // spaces
            for (int j = 1; j <= totRows - i; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
