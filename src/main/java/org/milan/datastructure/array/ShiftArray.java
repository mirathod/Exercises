package org.milan.datastructure.array;

/**
 * Problem:- Array: [12, 1, 13, 24, 12, 66, 12], X: 12 Replace X with 1 and move
 * remaining integers to last. Output: [1, 1, 1, 1, 13, 24, 66]
 *
 * @author Milan Rathod
 */
public class ShiftArray {

    public int[] computeFinalArray(int[] inputArray, int X) {
        int pointer = inputArray.length - 1;

        for (int i = pointer; i >= 0; --i) {
            if (inputArray[i] != X) {
                inputArray[pointer--] = inputArray[i];
            }
        }

        while (pointer >= 0) {
            inputArray[pointer--] = 1;
        }
        return inputArray;
    }

}
