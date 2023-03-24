package ArraysCC;

public class SubArr {
    public static void main(String[] args) {
        int arr[] = { 4, 10, 23, 11, 6 };
        print_subarray(arr);
    }

    // PRINT SUBARRAY
    public static void print_subarray(int arr[]) {
        int totalSubArrays = 0;
        for (int i = 0; i < arr.length; i++) {

            int start = i; // starting element of a subarray
            for (int j = i; j < arr.length; j++) {

                int end = j;// last element of a subarray
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                }
                totalSubArrays++;
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Total sub arrays : " + totalSubArrays);
        System.out.println();
    }
}
