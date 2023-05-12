/*
 * Job Sequencing Problem
 * 
 * Given an array of jobs where every job has a deadline and profit if the job is finished before the deadlline. 
 * It is also given that every job take as single unit of time, so the minimum possible deadline for any job is 1.
 * Maximize the total profit if only one job can be scheduled at a time.
 * 
 * job A=4, 20
 * job B=1, 10
 * job C=1, 40
 * job D=1, 30
 * 
 * ans = C, A
 * 
 * Approach - 
 * 1. sort jobs on the basis of profit 
 * 2. track time and create an ArrayList to store sequence of jobs
 *      time = 0  and ArrayList<Character>=new ArrayList<>()
 * 3. for(int i=0;i<jobs;i++){
 *          if( job(deadline) > time){
 *              add job in sequence ;
 *              time++;
 *          }
 *    }
 * 
 * In above approach we will select job with highest profit because we want to maximize the profit.
 */

package GreedyAlgorithms;

import java.util.*;

public class JobSequencing {

    static class Job {
        int deadline;
        int profit;
        int id;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {

        int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } }; // {deadline, profit}

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); // descending order of profit

        int time = 0;
        ArrayList<Integer> jobSequence = new ArrayList<>();

        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);

            if (curr.deadline > time) {
                jobSequence.add(curr.id);
                time++;
            }
        }

        System.out.println("Max jobs that can be done = " + jobSequence.size());

        for (int i = 0; i < jobSequence.size(); i++) {
            System.out.print(jobSequence.get(i) + " ");
        }
        System.out.println();

    }
}
