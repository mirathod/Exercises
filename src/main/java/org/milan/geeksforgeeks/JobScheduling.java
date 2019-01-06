package org.milan.geeksforgeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Algorithm: Greedy
 * <p>
 * Problem: {@link @https://www.geeksforgeeks.org/job-scheduling-two-jobs-allowed-time/}
 *
 * @author Milan Rathod
 */
public class JobScheduling {

    public boolean isCompletionPossible(int[] startTimes, int[] endTimes) {

        List<Integer> jobLists = new ArrayList<>();

        for (int i = 0; i < startTimes.length; i++) {
            jobLists.add(Integer.valueOf(startTimes[i] + "" + endTimes[i]));
        }

        Collections.sort(jobLists);

        char firstJob = jobLists.get(0).toString().charAt(1);
        char secondJob = jobLists.get(1).toString().charAt(1);

        for (int i = 2; i < jobLists.size(); i++) {
            char thirdJob = jobLists.get(i).toString().charAt(0);
            if (thirdJob > firstJob) {
                firstJob = jobLists.get(i).toString().charAt(1);
            } else if (thirdJob > secondJob) {
                secondJob = jobLists.get(i).toString().charAt(1);
            } else {
                return false;
            }
        }

        return true;
    }
}
