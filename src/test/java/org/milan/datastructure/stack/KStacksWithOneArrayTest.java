package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link KStacksWithOneArray}
 *
 * @author Milan Rathod
 */
public class KStacksWithOneArrayTest {

    @Test
    public void testPushPopOperations() {
        KStacksWithOneArray kStacksWithOneArray = new KStacksWithOneArray(6, 3);

        Assert.assertTrue(kStacksWithOneArray.isEmpty(0));
        Assert.assertTrue(kStacksWithOneArray.isEmpty(1));
        Assert.assertTrue(kStacksWithOneArray.isEmpty(2));

        kStacksWithOneArray.push(0, 10);
        kStacksWithOneArray.push(1, 20);
        kStacksWithOneArray.push(0, 30);
        kStacksWithOneArray.push(0, 40);
        kStacksWithOneArray.push(2, 50);
        kStacksWithOneArray.push(1, 60);

        Assert.assertEquals(40, kStacksWithOneArray.pop(0));
        Assert.assertEquals(60, kStacksWithOneArray.pop(1));
        Assert.assertEquals(50, kStacksWithOneArray.pop(2));

    }
}