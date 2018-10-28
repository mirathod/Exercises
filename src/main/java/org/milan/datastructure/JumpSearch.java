package org.milan.datastructure;

/**
 * Jump Search on sorted arrays
 *
 * @author Milan Rathod
 */
public class JumpSearch {

    /**
     * perform jump search - Time complexity O(sqrt(n))
     *
     * @param inputArray given array
     * @param number     element to search
     * @return return -1 if not found or index of the element in given array if found
     */
    public int jumpSearch(int[] inputArray, int number) {

        int arraySize = inputArray.length;

        int stepSize = (int) Math.floor(Math.sqrt(arraySize));

        int step = stepSize;

        int prev = 0;

        while (inputArray[Math.min(arraySize, step) - 1] < number) {
            prev = step;
            step += stepSize;
            if (prev >= arraySize) {
                // Element not present in given array return -1
                return -1;
            }
        }

        while (inputArray[prev] < number) {
            prev++;

            if (prev == Math.min(step, arraySize)) {
                // If we reach end of current block i.e. element is not present return -1
                return -1;
            }
        }

        if (inputArray[prev] == number) {
            return prev;
        }

        return -1;


    }
}
