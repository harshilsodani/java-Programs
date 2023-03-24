package Patterns;

public class HalfPyra {
    public static void main(String[] args) {
        half_pyramid(7);
    }
    // HALF PYRAMID 
    public static void half_pyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
