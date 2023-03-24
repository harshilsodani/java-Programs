package Patterns;

public class HollowRhombus {
    public static void main(String[] args) {
        hollow_rhombus(10);
    }

    // HOLLOW RHOMBUS
    public static void hollow_rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // hollow_rectangel(stars and spaces)
            for (int j = 1; j <= n; j++) {
                // cells -(i,j)
                if (i == 1 || i == n || j == 1 || j == n) {
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
