package org.milan.hackerearth;

/**
 * {@link @https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/batman-and-tick-tack-toe/}
 *
 * @author Milan Rathod
 */
public class BatmanAndTickTackToe {

    private static final int[][][] diagonalSet = {
            {{0, 0}, {1, 1}, {2, 2}},
            {{1, 1}, {2, 2}, {3, 3}},
            {{0, 3}, {1, 2}, {2, 1}},
            {{1, 2}, {2, 1}, {3, 0}},
            {{1, 3}, {2, 2}, {3, 1}},
            {{1, 0}, {2, 1}, {3, 2}},
            {{0, 1}, {1, 2}, {2, 3}},
            {{0, 2}, {1, 1}, {2, 0}},
    };

    /**
     * check if won scenario available in tic-tac-toe
     */
    public boolean isWonScenarioAvailable(char[][] matrix) {

        int countX = 0, countO = 0;

        for (int outer = 0; outer < 4; outer++) {
            for (int inner = 0; inner < 4; inner++) {
                if (matrix[outer][inner] == 'x') {
                    countX++;
                } else if (matrix[outer][inner] == 'o') {
                    countO++;
                }
            }
        }

        // next move of player
        char myChar = countX == countO ? 'x' : 'o';

        boolean wonFlag = false;
        // row wise check
        int counter = 0;
        while (counter < 4) {
            char[] rowsArr = matrix[counter++];

            if (isWonScenarioAvailableForRowsAndColumns(myChar, rowsArr)) return true;
        }

        counter = 0; // resetting it to ZERO.
        // column wise check
        while (counter < 4) {
            char[] columnsArr = {matrix[0][counter], matrix[1][counter], matrix[2][counter], matrix[3][counter]};

            if (isWonScenarioAvailableForRowsAndColumns(myChar, columnsArr)) return true;

            counter++;
        }

        return isWonScenarioAvailableForDiagonal(myChar, matrix);

    }

    private boolean isWonScenarioAvailableForRowsAndColumns(char myChar, char[] charArr) {

        boolean flag = isWonScenarioAvailableForRowsAndColumns(myChar, charArr, 0, 3);

        if (flag) {
            return true;
        } else {
            flag = isWonScenarioAvailableForRowsAndColumns(myChar, charArr, 1, 4);
            if (flag) {
                return true;
            }
        }

        return false;
    }

    /**
     * check if won scenario available for rows & columns
     */
    private boolean isWonScenarioAvailableForRowsAndColumns(char myChar, char[] charArr, int startIndex, int endIndex) {

        int myCharCount = 0, emptyCellCount = 0;

        for (int index = startIndex; index < endIndex; index++) {
            if (charArr[index] == myChar) myCharCount++;
            else if (charArr[index] == '.') emptyCellCount++;
        }

        if (myCharCount == 2 && emptyCellCount == 1) {
            return true;
        }

        return false;
    }

    /**
     * check if won scenario available for diagonal
     */
    private boolean isWonScenarioAvailableForDiagonal(char myChar, char[][] matrix) {
        int myCharCount = 0, emptyCellCount = 0;

        for (int index = 0; index < diagonalSet.length; index++) {
            int[][] eachSet = diagonalSet[index];
            for (int outer = 0; outer < eachSet.length; outer++) {
                int[] set = eachSet[outer];
                char currentChar = matrix[set[0]][set[1]];
                if (currentChar == myChar) myCharCount++;
                else if (currentChar == '.') emptyCellCount++;
            }
            if (myCharCount == 2 && emptyCellCount == 1) {
                return true;
            }
            myCharCount = 0;
            emptyCellCount = 0;
        }

        return false;
    }
}
