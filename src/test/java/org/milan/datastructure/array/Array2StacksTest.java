package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link Array2Stacks}
 *
 * @author Milan Rathod
 */
public class Array2StacksTest {

    @Test
    public void test() {
        Array2Stacks<Integer> a2s = new Array2Stacks<>(Integer.class, 10);
        a2s.push(1, 5);
        Integer result = a2s.pop(1);
        Assert.assertEquals(5, result.intValue());

        a2s.push(2, 10);
        result = a2s.pop(2);
        Assert.assertEquals(10, result.intValue());
    }
}