package org.milan.datastructure;

/**
 * binary search in array
 *
 * @author Milan Rathod
 */
public class BinarySearch {

    /**
     * Search number in input array with binary search
     *
     * @param arr    input array
     * @param number element to be searched
     * @return index of element if found otherwise -1
     */
    public int binarySearch(int[] arr, int number) {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;

        while (low <= high) {
            if (arr[mid] < number)
                low = mid + 1;
            else if (arr[mid] > number)
                high = mid - 1;
            else
                return mid;
            mid = (low + high) / 2;
        }
        return -1;
    }

}
