package org.milan.datastructure.array;

import java.util.Random;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/}
 *
 * @author Milan Rathod
 */
public class ShuffleElements {

    public int[] shuffle(int[] input) {

        Random random = new Random();
        for (int i = input.length - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            swap(input, i, j);
        }
        return input;
    }

    private void swap(int[] input, int source, int destination) {
        int temp = input[source];
        input[source] = input[destination];
        input[destination] = temp;
    }
}
