/*
 * Given two arrays A and B of equal length n. Pair each element of array A to element in array B, such that sum of absolute
 * differences of all the pairs is minimum.
 * 
 * eg. A={1,2,3};
 *     B={2,1,3};
 * 
 *      ans=0
 * 
 * Approach :
 *  we should pair thosse element of A and B together which are closet to each other  and to do this we should sort A and B
 *  so that smallest in A and smallest in B are paired together because they are closest.
 */

package GreedyAlgorithms;

import java.util.Arrays;

public class MinAbsoluteDifferencePairs {

    public static int minSum(int[] A, int[] B) { // O(nlogn )
        int minDiff = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] A = { 4, 1, 8, 7 };
        int[] B = { 2, 3, 6, 5 };

        System.out.println("Sum of min absolute difference of pairs : " + minSum(A, B));
    }
}
