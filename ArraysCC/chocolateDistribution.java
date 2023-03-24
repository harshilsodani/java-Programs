package ArraysCC;

import java.util.Arrays;

public class chocolateDistribution {
    public static void main(String[] args) {
        int[] arr = {3 , 4, 1, 9, 56, 7, 9, 12 };
        int m = 5;

        System.out.println("Minimum difference:" + cd(arr, m));
    }

    public static int cd(int[] arr, int m) {
        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - m; i++) {

            int diff1 = arr[i + m - 1] - arr[i];
            diff = Math.min(diff, diff1);

        }

        return diff;
    }
}
