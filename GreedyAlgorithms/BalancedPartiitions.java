/*
 * MAXIMUM BALANCED STRING PARTITIONS
 * 
 * We have balanced string str of size N with an equal number of L and R, the task is to find a maximum 
 * number X, such that the given string can be partitioned into X balanced substring. A string is called
 * balanced if number of 'L' in the string equals the number of 'R'.
 * 
 * str="LRRRRLLRLLRL"
 * output - 3
 * 
 * Approach -
 * - take two counter r =0 and l=0 to count the number of R and L respectively.
 * - int count=0; (to count the number of substrings which are balanced)
 * - for( int i=0;i<N;i++}:
 *      if(str.charAt(i)=="R")
 *          r++
 *      else
 *          l++
 *      
 *      if(i==l):
 *          count++;
 * 
 *  return count;
 */

package GreedyAlgorithms;

public class BalancedPartiitions {

    public static int balancedPartitions(String str, int n) {

        int count = 0;
        int r = 0, l = 0;

        if (n == 0)
            return 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R') {
                r++;
            } else {
                l++;
            }

            if (r == l) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        int N = str.length();

        System.out.println(balancedPartitions(str, N));

    }

}
