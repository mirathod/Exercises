package org.milan.datastructure;

import org.junit.Before;
import org.junit.Test;

/**
 * Add Description
 *
 * @author Milan Rathod
 * @since
 */
public class Array2StacksTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        Array2Stacks<Integer> a2s = new Array2Stacks<>(Integer.class, 10);
        a2s.push(1, 5);
        a2s.pop(1);
        a2s.pop(2);
    }
}