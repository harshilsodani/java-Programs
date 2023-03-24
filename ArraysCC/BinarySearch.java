package ArraysCC;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = { 4, 10, 23, 11, 6 };
        System.out.println(binary_search(arr,23));
    }

    // BINARY SEARCH
    public static int binary_search(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // comparisons
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
