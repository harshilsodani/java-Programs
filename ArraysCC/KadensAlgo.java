package ArraysCC;

public class KadensAlgo {
    public static void main(String[] args) {
        int arr[] = { 4, 10, 23, 11, 6 };
        kadanes(arr);
    }

    // KADEN'S ALGORITHM
    public static void kadanes(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int count = 0;

        // special case - checking if all elements present in the array are negative
        // in this case we will take smallest negative number as max subarray sum.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                count++;
            }
        }
        if (count == arr.length) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                max = arr[i] > max ? arr[i] : max;
            }
            System.out.println("Our maximum subarray sum is : " + max);
        } else {// if all the elements in the array are not negative then we apply simple kadens
                // algo.
            for (int i = 0; i < arr.length; i++) {
                currSum += arr[i];
                if (currSum < 0) {
                    currSum = 0;
                }
                maxSum = Math.max(maxSum, currSum);
            }
            System.out.println("Our maximum subarray sum is : " + maxSum);
        }
    }
}
