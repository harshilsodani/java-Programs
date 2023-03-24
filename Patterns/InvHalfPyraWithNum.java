package Patterns;

public class InvHalfPyraWithNum {
    public static void main(String[] args) {
        inverted_half_pyramid_withNumbers(10);
    }

    // INVERTED HALF PYRAMID WITH NUMBERS 
    public static void inverted_half_pyramid_withNumbers(int totRows) {
        // outer loop(rows)
        for (int i = 1; i <= totRows; i++) {

            // inner loop(columns)
            // numbers
            for (int j = 1; j <= totRows - i + 1; j++) {
                System.out.print(j + " ");
            }

            // spaces
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
