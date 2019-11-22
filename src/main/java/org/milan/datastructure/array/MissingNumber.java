package org.milan.datastructure.array;

/**
 * Problem: {@see @https://www.geeksforgeeks.org/find-the-missing-number/}
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
    public int findUsingXOR(int[] inputArray) {

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
     * NOTE: If size of array is large, this method might cause integer overflow
     * Time Complexity O(n)
     *
     * @param inputArray given array
     * @return missing number
     */
    public int findUsingSum(int[] inputArray) {

        int length = inputArray.length;

        int total = (length + 1) * (length + 2) / 2;

        for (int i = 0; i < length; i++)
            total -= inputArray[i];
        return total;
    }

    /**
     * find Missing Number -
     * Time Complexity O(n)
     *
     * @param inputArray given array
     * @return missing number
     */
    public int findUsingSubtract(int[] inputArray) {

        int total = 1;

        int length = inputArray.length;

        for (int i = 2; i <= length + 1; i++) {
            total += i;
            total -= inputArray[i - 2];
        }
        return total;
    }

}
