package org.milan.hackerearth;

/**
 * Problem: {@link @https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/linear-search-problem-1/}
 *
 * @author Milan Rathod
 */
public class LastOccurrence {

    /**
     * @param arr input array
     * @param M   element
     * @return last occurrence of element M in given array if present otherwise -1
     */
    public int get(int[] arr, int M) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (M == arr[i]) {
                index = i + 1;
            }
        }
        return index;
    }

}
