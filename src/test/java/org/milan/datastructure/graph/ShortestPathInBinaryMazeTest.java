package org.milan.datastructure.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link ShortestPathInBinaryMaze}
 *
 * @author Milan Rathod
 */
public class ShortestPathInBinaryMazeTest {

    @Test
    public void testFind() {
        int[][] maze = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};

        Point source = new Point(0, 0);
        Point dest = new Point(3, 4);

        ShortestPathInBinaryMaze shortestPathInBinaryMaze = new ShortestPathInBinaryMaze();

        int result = shortestPathInBinaryMaze.find(maze, source, dest);

        Assert.assertEquals(11, result);
    }
}