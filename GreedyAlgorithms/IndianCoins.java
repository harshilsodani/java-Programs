/*
 * We are given an infinite supply of denominations [1,2,5,10,20,50,100,500,2000], Find min. no of coins/notes to make change of a value V.
 * V=121
 * ans = 3  (100+20+1)
 * 
 * V=590
 * ans = 4  (500+50+20+20)
 * 
 * Approach -
 * 1. sort descending [2000,500,100,50,20,10,5,2,1]
 * 
 * 2.count=0;
 *   int n=coins.length;
 *   for(int i=0;i<n;i++){
 *      if(coins[i] <= amount){
 *          while(coins[i] <= amount){
 *              count++;
 *              amnount=amount-coins[i];
 *          }
 *      }
 *    }
 */

package GreedyAlgorithms;

import java.util.*;

public class IndianCoins {

    public static void main(String[] args) {
        Integer[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        int amount = 590;

        Arrays.sort(coins, Comparator.reverseOrder());

        ArrayList<Integer> ans = new ArrayList<>();
        int countOfCoins = 0;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    countOfCoins++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }

        System.out.println("Total (min) coins used = " + countOfCoins);
        System.out.println(ans);
    }
}
