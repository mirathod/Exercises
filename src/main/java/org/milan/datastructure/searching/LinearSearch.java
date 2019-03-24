package org.milan.datastructure.searching;

/**
 * Linear Search Algorithm
 *
 * @author Milan Rathod
 */
public class LinearSearch {

    /**
     * perform linear search - Time complexity of O(n).
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
