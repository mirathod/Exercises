package org.milan.misc;

/**
 * Problem: Given range of integers [A..B] find maximum number of repeated square root operations
 * <p>
 * Example: A = 10, B = 20
 * sqrt(16) = 4
 * sqrt(4) = 2
 * answer = 2
 *
 * @author Milan Rathod
 */
public class SquareRootOperations {

    public int solution(int a, int b) {

        int count = 0;

        a = (int) Math.ceil(Math.sqrt(a));
        b = (int) Math.floor(Math.sqrt(b));

        while (b >= a) {

            a = (int) Math.ceil(Math.sqrt(a));
            b = (int) Math.floor(Math.sqrt(b));
            count = count + 1;
        }
        return count;
    }

}


