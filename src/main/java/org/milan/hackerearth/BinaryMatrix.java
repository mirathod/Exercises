package org.milan.hackerearth;

import java.math.BigInteger;

/**
 * Problem: {@link @https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/binary-matrix-1-d77d7d00/}
 *
 * @author Milan Rathod
 */
public class BinaryMatrix {

    public int maxRowValue(int[][] matrix) {
        BigInteger maxValue = new BigInteger("0");
        int maxIndex = 0;
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder input = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                input.append(matrix[i][j]);
            }
            BigInteger decimal = new BigInteger(input.toString(), 2);
            if (maxValue.compareTo(decimal) < 0) {
                maxValue = decimal;
                maxIndex = i;
            }
        }
        return maxIndex + 1;
    }

}

