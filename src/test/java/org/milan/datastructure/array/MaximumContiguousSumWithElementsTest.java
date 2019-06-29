package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link MaximumContiguousSumWithElements}
 *
 * @author Milan Rathod
 */
public class MaximumContiguousSumWithElementsTest {

    @Test
    public void testSolution() {
        int[] a = {6, 1, 4, 6, 3, 2, 7, 4};

        int solution = new MaximumContiguousSumWithElements().solution(a, 3, 2);

        Assert.assertEquals(24, solution);
    }
}