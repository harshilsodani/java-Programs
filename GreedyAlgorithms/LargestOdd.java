/*
 * Kth LARGEST ODD NO. IN A GIVEN RANGE
 * 
 * we have two variables L and R , indicating a range of integers from L to R inclusive, and a number K,
 * the task is to find the kth largest odd number. if K > number of odd numbers in the range L to R then
 * return 0.
 * 
 * L=-3, R=3, K=1
 * output - 3
 * 
 * 
 * Approach -
 * - One possible approach is to sort the odd numbers in ascending order and return the kth largest number.
 * 
 * - Yet another approach is to maintain an array of k largest odd numbers in descending order as we 
 *   iterate over the odd numbers in the range. We can keep the array sorted using an insertion sort-like 
 *   algorithm and return the largest number in the array.
 * 
 * - Another approach is to use the properties of arithmetic progression to directly compute the kth 
 *   largest odd number without iterating over all the odd numbers in the range. We can compute the kth
 *   largest odd number in O(1) time using the formula (R - 2K + 2) for odd R and (R - 2K + 1) for even R,
 *   where K is the kth largest odd number we want to find and R is the upper bound of the range.
 */

package GreedyAlgorithms;

public class LargestOdd {

    public static int kthOdd(int L, int R, int k) {

        if (k <= 0) {
            return 0;
        }

        int l = L;
        int r = R;

        if ((R & 1) > 0) {

            int count = (int) Math.ceil((r - l + 1) / 2); // round off the answer
            if (k > count) {
                return 0;
            } else {
                return (r - 2 * k + 2);
            }

        } else {

            int count = (r - l + 1) / 2;
            if (k > count) {
                return 0;
            } else {
                return (r - 2 * k + 1);
            }

        }
    }

    public static void main(String[] args) {
        int L = -3, R = 10, K = 3;
        System.out.println(kthOdd(L, R, K));
    }
}
