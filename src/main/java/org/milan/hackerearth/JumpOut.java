package org.milan.hackerearth;

/**
 * {@link @https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/jump-out-34/}
 *
 * @author Milan Rathod
 */
public class JumpOut {

    public int minimumLengthJump(int[] inputArray, int length) {
        int jump = -1;
        for (int i = 0; i < length; i++) {
            if (inputArray[i] > length - i - 1) {
                jump = i + 1;
                break;
            }
        }
        return jump;
    }
}
