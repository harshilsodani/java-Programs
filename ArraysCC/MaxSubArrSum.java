package ArraysCC;

public class MaxSubArrSum {
    public static void main(String[] args) {
        int arr[] = { 4, 10, 23, 11, 6 };
        maxSubarraySum(arr);
    }

    // MAXIMUM SUBARRAY SUM
    public static void maxSubarraySum(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                int currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }

                // System.out.print("Sum =" + currSum);
                // System.out.println();
                if (currSum > max) {
                    max = currSum;
                }

            }
            // System.out.println();
        }
        System.out.println("Maximum subarry sum : " + max);
        System.out.println();
    }
}
