package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link MinimumElement}
 *
 * @author Milan Rathod
 */
public class MinimumElementTest {

    private MinimumElement minimumElement;

    @Before
    public void setup() {
        minimumElement = new MinimumElement();
    }

    @Test
    public void testGetMinimum() {
        minimumElement.push(2);
        minimumElement.push(6);
        minimumElement.push(4);
        minimumElement.push(1);
        minimumElement.push(5);

        Assert.assertEquals(1, minimumElement.getMinimum());

        minimumElement.pop();

        Assert.assertEquals(1, minimumElement.getMinimum());

        minimumElement.pop();

        Assert.assertEquals(2, minimumElement.getMinimum());
    }

    @Test
    public void testGetMinimumV2() {
        minimumElement.pushV2(2);
        minimumElement.pushV2(6);
        minimumElement.pushV2(4);
        minimumElement.pushV2(1);
        minimumElement.pushV2(5);

        Assert.assertEquals(1, minimumElement.getMinimumV2());

        minimumElement.popV2();

        Assert.assertEquals(1, minimumElement.getMinimumV2());

        minimumElement.popV2();

        Assert.assertEquals(2, minimumElement.getMinimumV2());
    }
}