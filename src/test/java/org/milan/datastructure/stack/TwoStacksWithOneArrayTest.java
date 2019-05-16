package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link TwoStacksWithOneArray}
 *
 * @author Milan Rathod
 */
public class TwoStacksWithOneArrayTest {

    private static final String STACK1 = "Stack1";

    private static final String STACK2 = "Stack2";

    @Test
    public void testPushPop() {
        TwoStacksWithOneArray twoStacksWithOneArray = new TwoStacksWithOneArray(4);

        twoStacksWithOneArray.push(STACK1, 5);

        twoStacksWithOneArray.push(STACK2, 10);

        twoStacksWithOneArray.push(STACK1, 15);

        twoStacksWithOneArray.push(STACK2, 20);

        Assert.assertEquals(15, twoStacksWithOneArray.pop(STACK1));

        Assert.assertEquals(20, twoStacksWithOneArray.pop(STACK2));
    }

}