package ArraysCC;

public class PairsInArr {
    public static void main(String[] args) {
        int arr[] = { 4, 10, 23, 11, 6 };
        print_pairs(arr);
    }

    // PRINT PARIRS IN ARRAY
    public static void print_pairs(int arr[]) {
        int totalPairs = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + curr + "," + arr[j] + ")  ");
                totalPairs++;
            }
            System.out.println();
        }
        System.out.println("Total pairs = " + totalPairs);

    }
}
