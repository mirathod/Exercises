package org.milan.geeksforgeeks;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Algorithm: Greedy
 * <p>
 * Problem: {@link @https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station-set-2-map-based-approach/}
 *
 * @author Milan Rathod
 */
public class MinimumPlatforms {

    private Map<Integer, String> trainMapping = new TreeMap<>();

    public int computeMinimumPlatforms(int[] arrivals, int[] departures) {

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

    private int getPlatformCount(String value) {
        if (value.length() == 1) {
            if ("a".equals(value)) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return getPlatformCount(value.substring(0, 1)) + getPlatformCount(value.substring(1, value.length()));
        }
    }
}
