package org.milan.algorithm.backtracking;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link RatInAMaze}
 *
 * @author Milan Rathod
 */
public class RatInAMazeTest {

    @Test
    public void testSolveMaze() {
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        RatInAMaze ratInAMaze = new RatInAMaze();

        boolean result = ratInAMaze.solveMaze(maze);

        Assert.assertTrue(result);
    }
}