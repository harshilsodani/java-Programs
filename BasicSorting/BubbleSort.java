package BasicSorting;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 3, 5, 6 };
        optimizedBubbleSort(arr);
        printArr(arr);
    }

    // BUBBLE SORT - Large elements come to the end of array by swapping
    // adjacent elements
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int turn = 0; turn < n - 1; turn++) {
            for (int j = 0; j < n - 1 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void optimizedBubbleSort(int arr[]) {

        int n = arr.length;
        for (int turn = 0; turn < n - 1; turn++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
