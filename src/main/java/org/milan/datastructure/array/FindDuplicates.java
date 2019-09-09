package org.milan.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Find Duplicates
 *
 * @author Milan Rathod
 */
public class FindDuplicates {

    /**
     * Find Duplicate elements in given input array
     *
     * @param inputArray input array
     * @return list of duplicate elements
     */
    public List<Integer> find(int[] inputArray) {

        List<Integer> outputList = new ArrayList<>();

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[Math.abs(inputArray[i])] > 0) {
                inputArray[Math.abs(inputArray[i])] = -inputArray[Math.abs(inputArray[i])];
            } else if (inputArray[Math.abs(inputArray[i])] < 0) {
                outputList.add(Math.abs(inputArray[i]));
            }
        }
        return outputList;
    }
}
