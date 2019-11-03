package org.milan.datastructure.heap;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/merge-k-sorted-arrays/}
 *
 * @author Milan Rathod
 */
public class MergeKSortedArrays {

    /**
     * Merge all sorted arrays into one array
     *
     * @param input 2d array of integers
     * @param k     numbers of sorted arrays to be merged
     * @return merged sorted array
     */
    public int[] merge(int[][] input, int k) {

        // Create binary min heap with k nodes. Every heap node has first element of an array
        BinaryHeap binaryHeap = new BinaryHeap(k, HeapType.MIN);

        int resultSize = 0;

        for (int i = 0; i < k; i++) {
            binaryHeap.insert(input[i][0]);
            resultSize += input[i].length;
        }

        int[] output = new int[resultSize];

        // One by one get the minimum element from the heap and replace it with next element of its array
        for (int i = 0; i < resultSize; i++) {

            // Get root element from min heap
            int min = binaryHeap.delete();

            output[i] = min;

            int nextElement = findNextElement(min, input);

            binaryHeap.insert(nextElement);
        }

        return output;

    }

    /**
     * Find next element to be inserted into heap by min element returned from heap
     * Find next element from same array in which min element was extracted if that element
     * is not last element otherwise return MAX integer value
     * <p>
     * NOTE: we can avoid this step by creating min heap with below structure
     * class minHeapNode {
     * int data;
     * // index of array from which element is taken
     * int arrayNumber;
     * // index of next element to be picked from array
     * int nextElement;
     * }
     */
    private int findNextElement(int data, int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == data && j != input[i].length - 1) {
                    return input[i][j + 1];
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
