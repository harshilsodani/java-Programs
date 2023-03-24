package DividenConquer;

public class QuickSort {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[], int si, int ei) {

        // base case
        if (si >= ei) {
            return;
        }

        // kaam
        int pIdx = partition(arr, si, ei); // here pIdx is index of pivot after partition
        quickSort(arr, si, pIdx - 1);// left part
        quickSort(arr, pIdx + 1, ei);// right part
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei]; // last element as pivot
        int i = si - 1; // to make place for elements smaller than pivot

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // last change to place pivot at right place
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static void main(String args[]) {
        int arr[] = { 6, 3, 9, 8, 2, 5 };
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
