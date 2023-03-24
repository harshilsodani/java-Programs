package BasicSorting;

public class CountSort {
    public static void main(String[] args) {
        int arr[] = { 4, 10, 23, 11, 6 };
        countSort(arr);
        printArr(arr);
    }

    // COUNTING SORT - mainly used when the range or max element is very small
    public static void countSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest + 1]; // here the size of count array is largest + 1 because we take 0 to largest.
        // count array is used to store the frequency of each elemnt present in the main
        // array.

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
