package Patterns;

public class HollowRect {
    public static void main(String[] args) {
        hollow_rectangle(7, 10);
    }

    // HOLLOW RECTANGLE 
    public static void hollow_rectangle(int totRows, int totCols) {
        // outer loop (Rows)
        for (int i = 1; i <= totRows; i++) {
            // inner loop (columns)
            for (int j = 1; j <= totCols; j++) {
                // cells -(i,j)
                if (i == 1 || i == totRows || j == 1 || j == totCols) {
                    // boundary condition
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
