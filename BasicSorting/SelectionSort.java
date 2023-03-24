package BasicSorting;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = { 4, 10, 23, 11, 6 };
        selectionSort(arr);
        printArr(arr);
    }

    // SELECTION SORT - Pick the smallest (from unsorted array) , put it at the
    // beginning
    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i; // position of minimum element in the array
            for (int j = i + 1; j < arr.length; j++) { // here j=i+1 because till 'i' we have sorted part of array and
                                                       // unsorted part of Array from 'i+1'
                if (arr[j] < arr[minPos]) { // if element on index j is less than element on minPos than j is new minPos
                    minPos = j;
                }
            }
            // swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
