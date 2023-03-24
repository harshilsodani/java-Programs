package Matrices;

public class StairCaseSearch {
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        staircaseSearch(matrix, 12);
    }

    // SEARCH IN A SORTED MATRIX - STAIRCASE SEARCH
    public static boolean staircaseSearch(int matrix[][], int key) {
        // STARTING ELEMENT - TOP RIGHT ELEMENT

        // int row = 0, col = matrix[0].length - 1;
        // while (row < matrix.length && col >= 0) {
        //     if (matrix[row][col] == key) {
        //         System.out.print("Key found at (" + row + "," + col + ")");
        //         return true;
        //     } else if (key > matrix[row][col]) {
        //         row++;
        //     } else {
        //         col--;
        //     }
        // }

        // STARTING ELEMENT - BOTTOM LEFT ELEMENT
        
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == key) {
                System.out.print("Key found at (" + row + "," + col + ")");
                return true;
            } else if (key > matrix[row][col]) {
                col++;
            } else {
                row--;
            }
        }
        System.out.println("Key not found!");
        return false;
    }
}
