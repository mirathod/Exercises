package org.milan.algorithm.searching;

/**
 * Problem: Linear Search
 * <p>
 * Time complexity: O(n)
 *
 * @author Milan Rathod
 */
public class LinearSearch {

    /**
     * Find given element with linear search
     *
     * @param inputArray given array
     * @param element    element to search in given array
     * @return -1 if not found or index of element in given array if found
     */
    public int search(int[] inputArray, int element) {

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == element) {
                return i;
            }
        }
        // return -1 if not found
        return -1;
    }
}
