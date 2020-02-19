package org.milan.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: Given a 2-D String array of student-marks find the student with the highest average and output his average score.
 * <p>
 * Input:  {{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}}
 * Output: 99
 * Explanation: Since Jessica's average is greater than Bob's, Mike's and Jason's average.
 *
 * @author Milan Rathod
 */
public class StudentWithMaxAvg {

    public int find(String[][] arr) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            String key = arr[i][0];
            int value = Integer.parseInt(arr[i][1]);

            if (map.containsKey(key)) {
                map.get(key).add(value);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                map.put(key, list);
            }
        }

        int max = -1;

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> integers = entry.getValue();
            int average = (int) integers.stream().mapToInt(i -> i)
                    .average().getAsDouble();

            if (average > max) {
                max = average;
            }
        }

        return max;
    }
}
