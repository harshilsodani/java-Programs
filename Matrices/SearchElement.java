package Matrices;

public class SearchElement {
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        search(matrix,12);
    }

    // SEARCH AN ELEMENT
    public static boolean search(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.print("Element found at cell: (" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.println("Element not found");
        return false;

    }

}
