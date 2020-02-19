package org.milan.algorithm.backtracking;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link RatInAMazeV2}
 *
 * @author Milan Rathod
 */
public class RatInAMazeV2Test {

    @Test
    public void testSolveMaze() {
        int[][] maze = {{2, 1, 0, 0},
                {3, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1}};
        RatInAMazeV2 ratInAMazeV2 = new RatInAMazeV2();

        boolean result = ratInAMazeV2.solveMaze(maze);

        Assert.assertTrue(result);
    }
}