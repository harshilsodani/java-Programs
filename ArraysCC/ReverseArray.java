package ArraysCC;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = { 4, 10, 23, 11, 6 };
        reverse_array(arr);
        printArr(arr);
    }

    // REVERSE AN ARRAY
    public static void reverse_array(int arr[]) {
        int first = 0, last = arr.length - 1;

        while (first < last) {
            // swap
            int temp = arr[last];
            arr[last] = arr[first];
            arr[first] = temp;
            first++;
            last--;
        }

    }

    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
