package org.milan.misc;

/**
 * Count Set bits in a number
 *
 * @author Milan Rathod
 */
public class CountSetBits {

    private static final int[] NUMBER_TO_BITS = new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};

    public int count(int number) {
        int count = 0;
        while (number > 0) {
            count += number & 1;
            number >>= 1;
        }
        return count;
    }

    public int countRec(int number) {
        if (number == 0) {
            return NUMBER_TO_BITS[0];
        }
        int nibble = number & 0xf;

        return NUMBER_TO_BITS[nibble] + countRec(number >> 4);
    }
}
