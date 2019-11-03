package org.milan.geeksforgeeks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link MaximumEvenLength}
 *
 * @author Milan Rathod
 */
public class MaximumEvenLengthTest {

    @Test
    public void testFind() {
        MaximumEvenLength maximumEvenLength = new MaximumEvenLength();

        String result = maximumEvenLength.find("this is a test string");

        Assert.assertEquals("string", result);

        result = maximumEvenLength.find("geeksforgeeks is a platform for geeks");

        Assert.assertEquals("platform", result);
    }
}