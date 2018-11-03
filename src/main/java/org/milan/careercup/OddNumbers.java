package org.milan.careercup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find two numbers which are present odd number of times in integer array
 * <p>
 * {@link @https://www.careercup.com/question?id=16306671}
 *
 * @author Milan Rathod
 */
public class OddNumbers {

    /**
     * @param inputArray given array
     * @return list of integers which are present in array odd number of times
     */
    public List<Integer> findOddNumbers(int[] inputArray) {

        Map<Integer, Integer> inputMap = new HashMap<>();

        List<Integer> outputList = new ArrayList<>();

        for (int element : inputArray) {
            Integer frequency = inputMap.get(element);
            inputMap.put(element, (frequency == null) ? 1 : frequency + 1);

        }

        for (Map.Entry<Integer, Integer> entry : inputMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                outputList.add(entry.getKey());
            }
        }
        return outputList;

    }

}