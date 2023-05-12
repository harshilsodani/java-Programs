/*
 * Maximum of All Sub-arrays of Size K
 *
 * we hava an array arr[] of size N and an integer k. Find the maximum for each and every contiguous subarray of size K.
 *
 * eg: N=9, K=3, arr={1,2,3,1,4,5,2,3,6}
 *     output - 3 3 4 5 5 5 6
 */

/**
 * The MaxOfAllSubArrOfSizeK class finds the maximum element in all subarrays of size k in an array
 * using a deque.
 */
package Queue;

import java.util.LinkedList;
// import java.util.ArrayList;
import java.util.Deque;

public class MaxOfAllSubArrOfSizeK {

    // Brute force approach:
    // public static void maxOfAllSubArrBF(int N, int k, int[] arr) {
        
    //     ArrayList<Integer> maxs = new ArrayList<>();

    //     for (int i = 0; i <= N-k; i++) {
    //         int max = arr[i];
    //         for (int j = i ; j < i + k ; j++) {
    //             max = Math.max(max, arr[j]);
    //         }
    //         maxs.add(max);
    //     }

    //     for (int i = 0; i < maxs.size(); i++) {
    //         System.out.print(maxs.get(i) + " ");
    //     }
    // }

    public static void maxOfAllSubArr(int N, int k, int[] arr) {
        Deque<Integer> Q = new LinkedList<>();

        int i = 0;

       
        // This code is initializing the deque `Q` with the first `k` elements of the array `arr`. It
        // is iterating over the first `k` elements of the array `arr` using the variable `i`, and for
        // each element, it is removing elements from the back of the deque `Q` if they are less than
        // or equal to the current element `arr[i]`. This ensures that the deque only contains elements
        // that are greater than the current element. Finally, it is adding the index `i` of the
        // current element to the back of the deque `Q`.
        for (i = 0; i < k; ++i) {
            while (!Q.isEmpty() && arr[i] >= arr[Q.peekLast()]) {
                Q.removeFirst();
            }
            Q.addLast(i);
        }

        
        for (; i < N; ++i) {
            System.out.print(arr[Q.peek()] + " ");

            
            // This code is removing elements from the front of the deque `Q` if they are outside the
            // current window of size `k`. The condition `Q.peek() <= i - k` checks if the index of the
            // element at the front of the deque is less than or equal to the current index `i` minus
            // `k`. If it is, then that element is outside the current window and can be removed from
            // the deque. This ensures that the deque only contains elements that are within the
            // current window.
            while (!Q.isEmpty() && Q.peek() <= i - k) {
                Q.removeFirst();
            }

            while (!Q.isEmpty() && arr[i] >= arr[Q.peekFirst()]) {
                Q.removeLast();
            }
            Q.addLast(i);
        }

        System.out.print(arr[Q.peek()] + " ");
    }

    public static void main(String[] args) {
        int N = 9;
        int k = 3;
        int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        maxOfAllSubArr(N, k, arr);
        // maxOfAllSubArrBF(N, k, arr);
    }
}
