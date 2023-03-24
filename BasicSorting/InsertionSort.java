package BasicSorting;

public class InsertionSort{
    public static void main(String[] args) {
        int arr[] = { 4, 10, 23, 11, 6 };
        insertionSort(arr);
        printArr(arr);
    }

    // INSERTION SORT - Pick an element (from unsorted part) & place in the right
    // positon in sorted part
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            // finding out the correct pos to insert
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            // insertion
            arr[prev + 1] = curr; // here prev+ 1 because if index go to -1 and other cases.

        }
    }
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
