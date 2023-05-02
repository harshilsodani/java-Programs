/*
 * you are given N ACTIVITIES with their start and end times. Select the maximum number of activities that can 
 * be performed by a single person, assuming that a person can only work on a single activity at a time.
 * ACTIVITIES ARE SORTED ACCORDING TO END TIME.
 * 
 * start=[10,12,20]
 * end=[20,25,30]
 * 
 * ans=2(A0 and A2)
 */

/*
 * approach:
   1) end time basic sort
   2) select A0 (1st activity) - because it has min. end time 
       - end time
      non - overlapping (disjoint)
       - start time >= end time of last chose activity
       count++


    NOTE : If we were given a jumbled start and end times then we will have to sort the end time in a
    ascending order and make changes in start time also and then solve the probelm 

    To sort the jumbled time, we have to use a 3D matrix , in which rows will represent activities and 
    0th col will represent index of activities, 1st col will represent start time and 2nd col represent 
    end time.
*/

package GreedyAlgorithms;

import java.util.*;

public class ActivitySelection {

    static class sol {
        int maxAct;
        ArrayList<Integer> activities;
    }

    public static sol activitySelection(int[] start, int[] end) { // O(n)

        // sorting
        int activitiesMatrix[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            activitiesMatrix[i][0] = i; // it will help to get original index , when activities will sort
            activitiesMatrix[i][1] = start[i];
            activitiesMatrix[i][2] = end[i];
        }

        // lambda function -> short form - use to sort 2D matrix
        Arrays.sort(activitiesMatrix, Comparator.comparingDouble(o -> o[2]));

        sol ans = new sol();
        ans.maxAct = 0;
        ans.activities = new ArrayList<>();

        // 1st Activity is always performed
        ans.maxAct = 1;
        ans.activities.add(activitiesMatrix[0][0]);

        int lastEnd = activitiesMatrix[0][2];

        for (int i = 0; i < end.length; i++) {
            if (activitiesMatrix[i][1] >= lastEnd) {

                // selct activity
                ans.maxAct++;
                ans.activities.add(activitiesMatrix[i][0]);
                lastEnd = activitiesMatrix[i][2];

            }
        }

        // for (int i = 0; i < activitiesMatrix.length; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         System.out.print(activitiesMatrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return ans;
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9, };

        // int[] start = { 0, 1, 3, 5, 5, 8 };
        // int[] end = { 6, 2, 4, 7, 9, 9 };

        sol ans = activitySelection(start, end);
        System.out.println("Max Activities = " + ans.maxAct);
        System.out.println("List of activities =" + ans.activities);
    }
}
