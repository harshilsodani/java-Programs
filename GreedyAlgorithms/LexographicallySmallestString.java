/*
 * LEXICOGRAPHICALLY SMALLEST STRING OF LENGTH N AND SUM K
 * 
 * We have two integers N and K. The task is to print the lexicographically smallest string of length N 
 * consisiting of lowercase english alphabets such that the sum of the characters of the string equals to
 * K where 'a'=1,'b'=2,'c'-3,.... and 'z'=26.
 * 
 * input - N=5, K=42
 * output - aaamz
 * 
 * 
 * Approach -
 * - Create a char array of length n and fill it with 'a' characters.
 * - Subtract n from k to get the remaining value that needs to be added to the string.
 * - Starting from the end of the string, iterate over the characters and add the highest value character possible while 
 *   keeping the remaining value less than 26.
 * - Calculate the remaining value by taking the minimum of k and 25, and set the current character to be the corresponding
 *   character for this value.
 * - Subtract the value of the current character from k and continue to the next character until all the remaining value has
 *   been added to the string.
 * - Return the resulting string.
 * 
 */

package GreedyAlgorithms;

import java.util.*;

public class LexographicallySmallestString {

    public static String smallestString(int n, int k) {

        char[] ans = new char[n];

        Arrays.fill(ans, 'a');

        k -= n; // remaining value of k after adding 'a' in string n times

        for (int i = n - 1; i >= 0 && k > 0; i--) {
            int remainingValue = Math.min(k, 25);
            ans[i] = (char) ('a' + remainingValue);
            k -= remainingValue;
        }

        return new String(ans);
    }

    public static void main(String[] args) {
        int N = 5, K = 42;
        System.out.println(smallestString(N, K));
    }
}
