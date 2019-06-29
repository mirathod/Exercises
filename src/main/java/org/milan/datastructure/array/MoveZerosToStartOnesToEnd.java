package org.milan.datastructure.array;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/move-all-zeros-to-start-and-ones-to-end-in-an-array-of-random-integers/}
 *
 * @author Milan Rathod
 */
public class MoveZerosToStartOnesToEnd {

    public void move(int[] inputArray) {

        int counter = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] != 1) {
                inputArray[counter++] = inputArray[i];
            }
        }

        while (counter < inputArray.length) {
            inputArray[counter++] = 1;
        }

        counter = inputArray.length - 1;

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
