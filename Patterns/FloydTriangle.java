package Patterns;

public class FloydTriangle {
    public static void main(String[] args) {
        floyds_triangle(7);
    }

    // FLOYD'S TRIANGLE
    public static void floyds_triangle(int totRows) {
        int num = 1;
        // outer loop(rows)
        for (int i = 1; i <= totRows; i++) {

            // inner loop(columns)
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }

            System.out.println();
        }
    }
}
