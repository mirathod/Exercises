package org.milan.datastructure.array;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/move-zeroes-end-array/}
 * <p>
 * Time Complexity O(n)
 *
 * @author Milan Rathod
 */
public class MoveZerosToStart {

    public void move(int[] inputArray) {

        int counter = inputArray.length - 1;

        for (int i = inputArray.length - 1; i >= 0; i--) {
            if (inputArray[i] != 0) {
                inputArray[counter--] = inputArray[i];
            }
        }

        while (counter >= 0) {
            inputArray[counter--] = 0;
        }
    }
}
