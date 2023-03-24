package Matrices;

public class DiagonalSum {
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        System.out.println(diagonalSum(matrix));
    }

    // DIAGONLA SUM
    public static int diagonalSum(int matrix[][]) {

        int sum = 0;
        // BRUTREFORCE method - O(n^2)
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         // pd
        //         if (i == j) {
        //             sum += matrix[i][j];
        //             // sd
        //         } else if (i + j == matrix.length - 1) {
        //             sum += matrix[i][j];
        //         }
        //     }
        // }

        // OPTIMIZED mehtod - O(n)
        for (int i = 0; i < matrix.length; i++) {
            // pd
            sum += matrix[i][i];
            // sd
            if (i != matrix.length - 1 - i) { // this condition only works when i!=j
                sum += matrix[i][matrix.length - 1 - i]; // here j=matrix.length - 1 -i
            }
        }

        return sum;
    }
}
