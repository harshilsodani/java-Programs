package Matrices;

public class SmallestAndLargestEle {
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        largestAndSmallesttElement(matrix);
    }
    // SMALLEST AND LARGEST ELEMENT
    public static void largestAndSmallesttElement(int matrix[][]) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > largest) {
                    largest = matrix[i][j];
                }
                if (matrix[i][j] < smallest) {
                    smallest = matrix[i][j];
                }
            }
        }
        System.out.println("Largest element = " + largest);
        System.out.println("Smallest element = " + smallest);
    }
}
