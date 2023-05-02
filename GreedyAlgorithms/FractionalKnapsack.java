/*
 * Given the weights and values of N items , put these items in a knapsack of capacity W to get the 
 * MAXIMUM TOTAL VALUE in the knapsack.
 * 
 * value=[60,100,120]
 * weight=[10,20,30]
 * W=50
 * 
 * ans = 240
 * 
 * - items given are dividable
 * 
 * Approach - calculate ratio of value and weight i.e. calculate value/weight for each given item 
 *          - select that item which has highest value per unit of item i.e. which have highest ratio
 */

package GreedyAlgorithms;
    
import java.util.*;

public class FractionalKnapsack {

    static class Solution {
        int maxValue;
        ArrayList<Integer> items;
    }

    public static Solution fractionalKnapsack(int[] value, int[] weight, int maxWeight) {

        double[][] itemMatrix = new double[value.length][4];

        for (int i = 0; i < value.length; i++) {
            itemMatrix[i][0] = i; // original index
            itemMatrix[i][1] = value[i]; // value
            itemMatrix[i][2] = weight[i]; // weight
            itemMatrix[i][3] = value[i] /(double) weight[i]; // ratio (value/weight)
        }

        Arrays.sort(itemMatrix, Comparator.comparingDouble(o -> o[3])); // matrix is sorted in ascending order of ratio

        Solution ans = new Solution();
        ans.maxValue = 0;
        ans.items = new ArrayList<>();

        int currWeight = 0;

        for (int i = itemMatrix.length - 1; i >= 0; i--) { // we have reverse loop so that we can include with highest
                                                           // ratio in the knapsack first

            if (currWeight + itemMatrix[i][2] <= maxWeight) {
                ans.maxValue += itemMatrix[i][1];
                ans.items.add((int)(itemMatrix[i][0]));
                currWeight += itemMatrix[i][2];
            } else {
                ans.maxValue += (maxWeight - currWeight) * itemMatrix[i][3];
                ans.items.add((int)itemMatrix[i][0]);
                currWeight += (maxWeight - currWeight);
                break;
            }
        }

        // for (int i = itemMatrix.length - 1; i >= 0; i--) {
        //     for (int j = 0; j < 4; j++) {
        //         System.out.print(itemMatrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return ans;
    }

    public static void main(String[] args) {
        int[] value = { 60, 100, 120 };
        int[] weight = { 10, 20, 30 };
        int maxWeight = 50;
        Solution ans = fractionalKnapsack(value, weight, maxWeight);

        System.out.println(ans.maxValue);
        System.out.println(ans.items);
    }
}
