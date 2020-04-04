package org.milan.datastructure.array;

import org.milan.util.ArrayUtil;

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

            // Swap input[i] with input[k]
            ArrayUtil.swap(input, i, j);
        }
        return input;
    }
}
