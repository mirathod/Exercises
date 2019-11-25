package org.milan.algorithm.greedy;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station-set-2-map-based-approach/}
 *
 * @author Milan Rathod
 */
public class MinimumPlatforms {

    private Map<Integer, String> trainMapping = new TreeMap<>();

    /**
     * Hash map based implementation
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param arrivals   array of arrival times
     * @param departures array of departure times
     * @return minimum platform required
     */
    public int getMinimumPlatforms(int[] arrivals, int[] departures) {

        for (int i = 0; i < arrivals.length; i++) {
            if (trainMapping.containsKey(arrivals[i])) {
                trainMapping.put(arrivals[i], trainMapping.get(arrivals[i]).concat("a"));
            } else {
                trainMapping.put(arrivals[i], "a");
            }

            if (trainMapping.containsKey(departures[i])) {
                trainMapping.put(departures[i], trainMapping.get(departures[i]).concat("d"));
            } else {
                trainMapping.put(departures[i], "d");
            }

        }

        int platformNeeded = 0;

        int output = 0;

        Set<Map.Entry<Integer, String>> entries = trainMapping.entrySet();

        for (Map.Entry<Integer, String> entry : entries) {
            String value = entry.getValue();

            platformNeeded += getPlatformCount(value);

            if (platformNeeded > output) {
                output = platformNeeded;
            }

        }
        return output;
    }

    /**
     * Using merge process of merge sort
     * <p>
     * Time complexity: O(nlogn)
     * Space complexity: O(1)
     *
     * @param arrivals   array of arrival times
     * @param departures array of departure times
     * @return minimum platform required
     */
    public int getMinimumPlatformsV2(int[] arrivals, int[] departures) {

        if (arrivals.length != departures.length) {
            throw new IllegalStateException("Invalid inputs");
        }

        int n = arrivals.length;

        // Sort both the arrivals and departures array
        Arrays.sort(arrivals);

        Arrays.sort(departures);

        int platformNeeded = 1;

        int result = 1;

        int i = 1;

        int j = 0;

        // Follow similar to merge in merge process
        while (i < n && j < n) {

            // If next event in sorted order is arrival, increment count of platforms needed
            // Else decrement count of platforms needed
            if (arrivals[i] < departures[j]) {
                platformNeeded++;
                i++;

                if (platformNeeded > result) {
                    result = platformNeeded;
                }
            } else {

                platformNeeded--;
                j++;
            }
        }
        return result;
    }

    private int getPlatformCount(String value) {
        if (value.length() == 1) {
            if ("a".equals(value)) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return getPlatformCount(value.substring(0, 1)) + getPlatformCount(value.substring(1));
        }
    }
}
