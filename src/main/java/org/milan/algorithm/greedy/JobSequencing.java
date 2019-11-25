package org.milan.algorithm.greedy;

import java.util.Arrays;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/job-sequencing-problem/}
 *
 * @author Milan Rathod
 */
public class JobSequencing {

    public String find(Job[] jobs) {

        // Sort all jobs according to decreasing order of profit
        Arrays.sort(jobs, (o1, o2) -> o2.profit - o1.profit);

        // To keep track of free time slots
        boolean[] slots = new boolean[jobs.length];

        // To keep track of scheduled jobs
        int[] result = new int[jobs.length];

        StringBuilder output = new StringBuilder();

        // Iterate through all jobs
        for (int i = 0; i < jobs.length; i++) {


            for (int j = Math.min(jobs.length, jobs[i].deadline) - 1; j >= 0; j--) {
                if (!slots[j]) {
                    result[j] = i;
                    slots[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < jobs.length; i++) {
            if (slots[i]) {
                output.append(jobs[result[i]].jobId);
            }
        }
        return output.toString();
    }
}

class Job {
    char jobId;

    int deadline;

    int profit;

    public Job(char jobId, int deadline, int profit) {
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }
}
