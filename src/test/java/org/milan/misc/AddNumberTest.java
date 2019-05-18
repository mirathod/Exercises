package org.milan.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link AddNumber}
 *
 * @author Milan Rathod
 */
public class AddNumberTest {

    @Test
    public void testAdd() {
        AddNumber addNumber = new AddNumber();
        int result = addNumber.add(11);

        Assert.assertEquals(12, result);
    }
}