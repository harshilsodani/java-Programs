package RecursionBasics;

public class LastOccurence {
    public static void main(String[] args) {
        int arr[] = { 8, 3, 6, 9, 5, 10, 2, 5, 3 };
        // int arr[] = { 5, 5, 5, 5 };
        System.out.println(lastOccur(arr, 0, 5));
    }

    public static int lastOccur(int arr[], int i, int key) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccur(arr, i + 1, key);
        if (isFound == -1 && key == arr[i]) {
            return i;
        }
        return isFound;
    }
}
