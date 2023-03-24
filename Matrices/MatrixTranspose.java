package Matrices;

public class MatrixTranspose {
    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3 },
                { 5, 6, 7 } };

        int newMatrix[][] = matrixTranspose(matrix);
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixTranspose(int matrix[][]) {

        int newMatrix[][] = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }

        return newMatrix;
    }
}
