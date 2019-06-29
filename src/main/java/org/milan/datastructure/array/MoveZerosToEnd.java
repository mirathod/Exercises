package org.milan.datastructure.array;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/move-zeroes-end-array/}
 * <p>
 * Time Complexity O(n)
 *
 * @author Milan Rathod
 */
public class MoveZerosToEnd {

    public void move(int[] inputArray) {

        int counter = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] != 0) {
                inputArray[counter++] = inputArray[i];
            }
        }

        while (counter < inputArray.length) {
            inputArray[counter++] = 0;
        }
    }
}
