package org.milan.geeksforgeeks;

/**
 * Problem Link  {@see @https://www.geeksforgeeks.org/find-the-missing-number/}
 *
 * @author Milan Rathod
 */
public class MissingNumber {

    /**
     * find Missing Number - XOR method
     * Time Complexity - O(n)
     *
     * @param inputArray given array
     * @return missing number
     */
    public int findMissingNumber(int[] inputArray) {

        int arraySize = inputArray.length;

        int i;
        int x1 = inputArray[0];
        int x2 = 1;

        for (i = 1; i < arraySize; i++)
            x1 = x1 ^ inputArray[i];

        for (i = 2; i <= arraySize + 1; i++)
            x2 = x2 ^ i;

        return (x1 ^ x2);
    }

    /**
     * find Missing Number - Sum All numbers method
     * Time Complexity O(n)
     *
     * @param inputArray given array
     * @param arraySize  size of an array
     * @return missing number
     */
    public int findMissingNumber(int[] inputArray, int arraySize) {

        int total = (arraySize + 1) * (arraySize + 2) / 2;

        for (int i = 0; i < arraySize; i++)
            total -= inputArray[i];
        return total;
    }


}
