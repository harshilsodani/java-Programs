/*
 * CHOCOLA PROBLEM (hard, classical, Important)
 * MIN. COST TO CUT BOARD INTO SQUARES  
 * 
 * we are givne a bar of chocolate composed of m X n square pieces. One should break the chocolate into single
 * squares .Each break of a part of the chocolate is charged a cost expressed by a positive integer. The cost
 * dose not depend on the size of the part that is being broken but only depends on the line the break goes along.
 * Let us denote the cost of breaking along consecutive vertical lines with x1, x2, x3,...,xm-1 and along
 * horizontal lines with y1, y2, ...,yn-1.
 * 
 * Compute the minimal cost of breaking the whole chocolate into single squares.
 * 
 * Imp. points -
 * 1. I will have to use all cuts - (problem is to decide order of cuts)
 * 2. after each cut - chocolate pieces increase therefore make
 *     -> expensive cuts first
 *     -> cheat cuts last
 * 3. cost of vertica cut = horizontal pieces * cost of single vertical cut
 *    const of horizontal cut = vertical pieces * cost of single horizontal cut 
 * 
 * Approach -
 * 1. sort horizontal and vertical costs in descending order
 * 2. take two pointer h and v to track the horizontal anv vertical cuts  (int h=0,v=0)
 * 3. take two variable hp and vp to keep count of horizontal and vertical pieces (int hp=1,vp=1)
 * 4. while( h < horizontal.length && v < vertical.length:
 *      if(v < h):
 *          make vertical cut (calculate cost and update vp and hp)
 *      else:
 *          make horizontal cut (calculate cost and update vp and hp)
 * 5. make remaining horizontal and vertical cuts.
 * 
 */

package GreedyAlgorithms;

import java.util.*;

public class ChocolaProblem {
    public static void main(String[] args) {

        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 }; // m-1
        Integer costHor[] = { 4, 1, 2 }; // n-1

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; // h - horizontal pointer and v - vertical pointer
        int hp = 1, vp = 1; // hp - horizontal pieces and vp - vertical pieces
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) { // make horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else { // make vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        while (h < costHor.length) { // for remaining horizontal cuts
            cost += (costHor[h] * vp);
            h++;
            hp++;
        }

        while (v < costVer.length) { // for remaining vertical cuts
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Min. cost = " + cost);
    }
}
