package RecursionBasics;

public class FirstOccurence {
    public static void main(String[] args) {
        int arr[] = { 8, 3, 6, 9, 5, 10, 2, 5, 3 };
        System.out.println(firstOccur(arr, 0, 5));
    }

    // first occurence of key in an array
    public static int firstOccur(int arr[], int i, int key) {
        if (i == arr.length) {
            return -1;
        }
        if (key == arr[i]) {
            return i;
        }
        return firstOccur(arr, i + 1, key);
    }
}
