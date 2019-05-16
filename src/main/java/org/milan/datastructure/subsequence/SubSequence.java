package org.milan.datastructure.subsequence;

import java.math.BigInteger;

/**
 * Sub Sequence of a string
 *
 * @author Milan Rathod
 */
public class SubSequence {

    public static void main(String[] args) {
        new SubSequence().subSequence(new char[]{'a', 'b', 'c'}, 3);
    }

    public void subSequence(char[] set, int setSize) {
        for (int counter = 1; counter < (1 << setSize); counter++) {
            for (int j = 0; j < setSize; j++) {
                if (BigInteger.valueOf(counter).testBit(j)) {
                    System.out.print(set[j] + " ");
                }
            }
            System.out.println();
        }
    }
}
