package org.milan.datastructure.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find Minimum and Maximum element in an array
 * <p>
 * {@link @https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/}
 * <p>
 * Time Complexity - O(n)
 *
 * @author Milan Rathod
 */
public class MinMaxInArray {

    /**
     * Approach 1: Simple Linear Search
     * <p>
     * No of Comparison
     * <p>
     * Worse Case: 1 + 2(n-2)
     * Base Case: 1 + n - 2
     */
    public List<Integer> findMinMax(int[] inputArray) {

        List<Integer> outputArray = new ArrayList<>();

        if (!checkBaseConditions(inputArray)) {
            return Collections.emptyList();
        }

        // if given array has only one element than return that element as max and min
        if (inputArray.length == 1) {
            outputArray.add(inputArray[0]);
            outputArray.add(inputArray[0]);
            return outputArray;
        }

        int minimum;

        int maximum;

        // assign first and second element of array to min & max
        if (inputArray[0] > inputArray[1]) {
            maximum = inputArray[0];
            minimum = inputArray[1];
        } else {
            maximum = inputArray[1];
            minimum = inputArray[0];
        }

        for (int i = 2; i < inputArray.length; i++) {

            // if current element it greater than max, assign it to max
            if (inputArray[i] > maximum) {
                maximum = inputArray[i];
            }

            // if current element it smaller than min, assign it to min
            if (inputArray[i] < minimum) {
                minimum = inputArray[i];
            }

        }

        outputArray.add(minimum);
        outputArray.add(maximum);

        return outputArray;
    }

    /**
     * Approach 2: Compare in pairs
     * <p>
     * No of Comparison
     * <p>
     * Base Case: 3n/2 - 2
     */
    public List<Integer> findMinMax(int[] inputArray, int length) {

        List<Integer> outputArray = new ArrayList<>();

        if (!checkBaseConditions(inputArray)) {
            return Collections.emptyList();
        }

        int indexCounter = 0;

        int minimum;

        int maximum;

        if (length % 2 == 0) {
            // assign first and second element of array to min & max
            if (inputArray[0] < inputArray[1]) {
                maximum = inputArray[1];
                minimum = inputArray[0];
            } else {
                maximum = inputArray[0];
                minimum = inputArray[1];
            }
            indexCounter = 2;
        } else {
            maximum = inputArray[0];
            minimum = inputArray[0];
            indexCounter = 1;
        }

        while (indexCounter < length - 1) {

            if (inputArray[indexCounter] > inputArray[indexCounter + 1]) {

                if (inputArray[indexCounter] > maximum) {
                    maximum = inputArray[indexCounter];
                }

                if (inputArray[indexCounter + 1] < minimum) {
                    minimum = inputArray[indexCounter + 1];
                }
            } else {

                if (inputArray[indexCounter + 1] > maximum) {
                    maximum = inputArray[indexCounter + 1];
                }

                if (inputArray[indexCounter] < minimum) {
                    minimum = inputArray[indexCounter];
                }
            }

            indexCounter += 2;
        }

        outputArray.add(minimum);
        outputArray.add(maximum);

        return outputArray;

    }

    /**
     * Approach 2: Tournament method
     * <p>
     * No of Comparison
     * <p>
     * Worse Case: > 3n/2 -2 if n is not a power of 2
     * Base Case: = 3n/2 -2 if n is a power of 2
     */
    public List<Integer> findMinMax(int[] inputArray, int low, int high) {

        List<Integer> outputArray = new ArrayList<>();

        if (!checkBaseConditions(inputArray)) {
            return Collections.emptyList();
        }

        // if given array has only one element than return that element as max and min
        if (low == high) {
            outputArray.add(inputArray[low]);
            outputArray.add(inputArray[low]);
            return outputArray;
        } else if (high == low + 1) {
            // assign first and second element of array to min & max
            if (inputArray[low] > inputArray[high]) {
                outputArray.add(inputArray[high]);
                outputArray.add(inputArray[low]);
            } else {
                outputArray.add(inputArray[low]);
                outputArray.add(inputArray[high]);
            }
            return outputArray;
        }

        List<Integer> leftMinMax;

        List<Integer> rightMinMax;

        int mid = (low + high) / 2;

        leftMinMax = findMinMax(inputArray, low, mid);

        rightMinMax = findMinMax(inputArray, mid + 1, high);

        // compare min value of left and right temp array
        if (leftMinMax.get(0) < rightMinMax.get(0)) {
            outputArray.add(leftMinMax.get(0));
        } else {
            outputArray.add(rightMinMax.get(0));
        }

        // compare max value of left and right temp array
        if (leftMinMax.get(1) > rightMinMax.get(1)) {
            outputArray.add(leftMinMax.get(1));
        } else {
            outputArray.add(rightMinMax.get(1));
        }

        return outputArray;

    }

    private boolean checkBaseConditions(int[] inputArray) {
        if (inputArray == null || inputArray.length < 1) {
            return false;
        }
        return true;
    }
}
