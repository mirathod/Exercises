package org.milan.datastructure.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find first and second smallest element in array
 * <p>
 * {@link @https://www.geeksforgeeks.org/to-find-smallest-and-second-smallest-element-in-an-array/}
 * <p>
 * Time Complexity - O(n)
 *
 * @author Milan Rathod
 */
public class SmallestElements {

    public List<Integer> findSmallestElements(int[] inputArray) {

        if (!checkBaseConditions(inputArray)) {
            return Collections.emptyList();
        }

        List<Integer> outputArray = new ArrayList<>();

        int first = Integer.MAX_VALUE;
        int second = first;

        for (int i = 0; i < inputArray.length - 1; i++) {

            // check if current element is less than first element
            if (inputArray[i] < first) {
                second = first;
                first = inputArray[i];
            }

            // check if current element is less than second element
            if (inputArray[i] < second && inputArray[i] != first) {
                second = inputArray[i];
            }
        }

        if (second == Integer.MAX_VALUE) {
            return Collections.emptyList();
        } else {
            outputArray.add(first);
            outputArray.add(second);
        }

        return outputArray;
    }

    private boolean checkBaseConditions(int[] inputArray) {

        // check if array is empty or has less than 2 elements
        if (inputArray == null || inputArray.length < 2) {
            return false;
        }

        return true;
    }
}
