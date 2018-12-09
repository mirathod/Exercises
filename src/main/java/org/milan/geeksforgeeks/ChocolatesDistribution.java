package org.milan.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link @https://www.geeksforgeeks.org/maximum-number-chocolates-distributed-equally-among-k-students/}
 *
 * @author Milan Rathod
 */
public class ChocolatesDistribution {

    public int maxNumOfChocolates(int[] arr, int n, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        // 'sum[]' to store cumulative sum, where
        // sum[i] = sum(arr[0]+..arr[i])
        long[] sum = new long[n];
        int currentRemainder;

        // To store sum of sub-array having maximum sum
        long maxSum = 0;

        // Building up 'sum[]'
        sum[0] = arr[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + arr[i];

        // Traversing 'sum[]'
        for (int i = 0; i < n; i++) {

            // Finding current remainder
            currentRemainder = (int) (sum[i] % k);

            // If true then sum(0..i) is divisible
            // by k
            if (currentRemainder == 0) {
                // update 'maxSum'
                if (maxSum < sum[i])
                    maxSum = sum[i];
            }

            // If value 'currentRemainder' not present in map
            // then store it in map with index of its
            // first occurrence
            else if (!map.containsKey(currentRemainder))
                map.put(currentRemainder, i);

            else
                // If true, then update 'max'
                if (maxSum < (sum[i] - sum[map.get(currentRemainder)]))
                    maxSum = sum[i] - sum[map.get(currentRemainder)];
        }

        // Required maximum number of chocolates to be
        // distributed equally among 'k' students
        return (int) (maxSum / k);
    }

}
