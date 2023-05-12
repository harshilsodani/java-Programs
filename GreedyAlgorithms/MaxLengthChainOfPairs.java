/*
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c,d) 
 * can come after pair (a,b) if b<c.
 * Find the longest chain which can be formed from a given set of pairs.
 * 
 * eg. pairs=
 *      (5,24) (39,60) (5,28) (27,40) (50,90)
 *  ans = 3
 *  pairs - (5,24) , (27,40) and (50,90)
 * 
 * Approach : // Similar to Activity Selection
 * 1. sort pairs (base on 2nd number)
 * 2. select 1st pair
 * 3. for( int i=1;i<n;i++){
 *      if(pair.starting > lastSelected.end){
 *          ans++;
 *          update lastSelected.end;
 *      }
 *    }
 * 
 */

package GreedyAlgorithms;

import java.util.*;

public class MaxLengthChainOfPairs {

    public static int maxLength(int[][] pairs) { // O(nlogn)
        int maxLength = 0;

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int pairEnd = pairs[0][1]; // Last Selected pair end // chair end
        maxLength = 1;

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > pairEnd) {
                maxLength++;
                pairEnd = pairs[i][1];
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        System.out.println("Maximum length of chain = " + maxLength(pairs));
    }
}
