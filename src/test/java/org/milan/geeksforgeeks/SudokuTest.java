package org.milan.geeksforgeeks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link Sudoku}
 *
 * @author Milan Rathod
 */
public class SudokuTest {

    private int[][] validSudoku;

    private int[][] invalidSudoku;

    private Sudoku sudoku;

    @Before
    public void setUp() {
        validSudoku = new int[][]{
                {7, 2, 6, 4, 9, 3, 8, 1, 5},
                {3, 1, 5, 7, 2, 8, 9, 4, 6},
                {4, 8, 9, 6, 5, 1, 2, 3, 7},
                {8, 5, 2, 1, 4, 7, 6, 9, 3},
                {6, 7, 3, 9, 8, 5, 1, 2, 4},
                {9, 4, 1, 3, 6, 2, 7, 5, 8},
                {1, 9, 4, 8, 3, 6, 5, 7, 2},
                {5, 6, 7, 2, 1, 4, 3, 8, 9},
                {2, 3, 8, 5, 7, 9, 4, 6, 1}
        };

        invalidSudoku = new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        sudoku = new Sudoku();
    }

    @Test
    public void testIsValidSudoku() {
        assertTrue(sudoku.isValidSudoku(validSudoku));
        assertFalse(sudoku.isValidSudoku(invalidSudoku));
    }

    @Test
    public void testIsValidSudokuV2() {
        assertTrue(sudoku.IsValidSudokuV2(validSudoku));
        assertFalse(sudoku.IsValidSudokuV2(invalidSudoku));
    }
}