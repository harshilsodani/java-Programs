package ArraysCC;

public class PrefixSubArrSum {
    public static void main(String[] args) {
        int arr[] = { 4, 10, 23, 11, 6 };
        prefixSum(arr);
    }

    // PREFIX SUBARRAY SUM
    public static void prefixSum(int arr[]) {
        int max = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];
        int currSum = 0;

        // calculate prefix
        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;

                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                if (currSum > max) {
                    max = currSum;
                }

            }
        }
        System.out.println("Maximum subarry sum : " + max);
        System.out.println();
    }
}
