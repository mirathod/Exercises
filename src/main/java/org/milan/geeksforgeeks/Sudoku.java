package org.milan.geeksforgeeks;

import java.util.HashSet;
import java.util.Set;

/**
 * Check if given sudoku solution is valid or not
 * <p>
 * Problem: {@link @https://www.geeksforgeeks.org/check-if-given-sudoku-board-configuration-is-valid-or-not/}
 *
 * @author Milan Rathod
 */
public class Sudoku {

    public boolean isValidSudoku(int[][] matrix) {

        // Used for storing numbers 1-9 and checking for duplicate
        Set<Integer> numbers = new HashSet<>();

        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        // Row wise comparision
        for (int i = 0; i < rowLength; i++) {

            for (int j = 0; j < columnLength; j++) {
                if (!numbers.add(matrix[i][j])) {
                    return false;
                }
            }
            numbers.clear();
        }

        // Column wise comparision
        for (int i = 0; i < rowLength; i++) {

            for (int j = 0; j < columnLength; j++) {
                if (!numbers.add(matrix[j][i])) {
                    return false;
                }
            }
            numbers.clear();
        }

        // Box wise comparison

        // Row start index
        int rowStart = 0;

        // Row end index
        int rowEnd = 3;

        // Column start index
        int columnStart = 0;

        // Column end index
        int columnEnd = 3;

        // Count of number of boxes in row
        int rowBoxCount = 0;

        // Count of number of boxes in column
        int columnBoxCount = 0;

        while (columnBoxCount < 3) {

            while (rowBoxCount < 3) {

                while (rowStart < rowEnd) {

                    int tempColumnStart = columnStart;
                    while (tempColumnStart < columnEnd) {
                        if (!numbers.add(matrix[rowStart][tempColumnStart++])) {
                            return false;
                        }
                    }
                    rowStart++;
                }

                numbers.clear();

                rowEnd += 3;

                rowBoxCount++;
            }

            // Reset rowStart and rowEnd
            rowStart = 0;
            rowEnd = 3;

            // Increment columnStart and columnEnd by 3
            columnStart += 3;
            columnEnd += 3;
            columnBoxCount++;
        }

        return true;
    }

    /**
     * Optimized solution
     */
    public boolean IsValidSudokuV2(int[][] matrix) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                String key = "(" + matrix[i][j] + ")";

                if (!set.add(key + i) || !set.add(j + key) || !set.add(i / 3 + key + j / 3)) {
                    return false;
                }
            }
        }
        return true;
    }
}
