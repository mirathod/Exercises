package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link CelebrityProblem}
 *
 * @author Milan Rathod
 */
public class CelebrityProblemTest {

    private CelebrityProblem celebrityProblem;

    @Before
    public void setUp() throws Exception {

        int[][] matrix = {{0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}};

        celebrityProblem = new CelebrityProblem(matrix);
    }

    @Test
    public void testFindCelebrity() {
        int result = celebrityProblem.findCelebrity(4);

        Assert.assertEquals(2, result);
    }

    @Test
    public void testFindCelebrityV2() {
        int result = celebrityProblem.findCelebrityV2(4);

        Assert.assertEquals(2, result);
    }
}