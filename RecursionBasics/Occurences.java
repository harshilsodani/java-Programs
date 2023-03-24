package RecursionBasics;

public class Occurences {
    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        int key = 2;
        findOccurences(arr, key, 0);
        System.out.println();
    }

    public static void findOccurences(int arr[], int key, int i) {
        // base case
        if (i == arr.length) {
            return;
        }

        // work
        if (arr[i] == key) {
            System.out.print(i + " ");
        }

        findOccurences(arr, key, i + 1);
    }
}
