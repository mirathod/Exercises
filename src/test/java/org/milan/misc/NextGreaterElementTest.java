package org.milan.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link NextGreaterElement}
 *
 * @author Milan Rathod
 */
public class NextGreaterElementTest {

    @Test
    public void testFind() {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();

        int result = nextGreaterElement.find(534976);

        Assert.assertEquals(536479, result);

        result = nextGreaterElement.find(4321);

        Assert.assertEquals(4321, result);
    }
}