package org.milan.algorithm.searching;

/**
 * Jump Search on sorted arrays
 * <p>
 * Time complexity: O(sqrt(n))
 *
 * @author Milan Rathod
 */
public class JumpSearch {

    /**
     * perform jump search
     *
     * @param inputArray given array
     * @param number     element to search
     * @return return -1 if not found or index of the element in given array if found
     */
    public int search(int[] inputArray, int number) {

        int length = inputArray.length;

        int stepSize = (int) Math.floor(Math.sqrt(length));

        int step = stepSize;

        int prev = 0;

        // Finding the block where element is present (if it is present)
        while (inputArray[Math.min(length, step) - 1] < number) {
            prev = step;
            step += stepSize;
            if (prev >= length) {
                // Element not present in given array return -1
                return -1;
            }
        }

        // Linear search for x in block beginning with prev
        while (inputArray[prev] < number) {
            prev++;

            // If we reach end of current block i.e. element is not present
            if (prev == Math.min(step, length)) {
                return -1;
            }
        }

        // If element is found
        if (inputArray[prev] == number) {
            return prev;
        }

        return -1;
    }
}
