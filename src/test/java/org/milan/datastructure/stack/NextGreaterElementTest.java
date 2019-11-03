package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link NextGreaterElement}
 *
 * @author Milan Rathod
 */
public class NextGreaterElementTest {

    @Test
    public void testFindAll() {
        int[] input = {4, 5, 2, 25};
        NextGreaterElement nextGreaterElement = new NextGreaterElement();

        int[] result = nextGreaterElement.findAll(input);

        Assert.assertArrayEquals(new int[]{5, 25, 25, -1}, result);
    }
}