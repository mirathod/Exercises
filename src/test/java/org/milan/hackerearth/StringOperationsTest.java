package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class {@link StringOperations}
 *
 * @author Milan Rathod
 */
public class StringOperationsTest {

    private StringOperations stringOperations;

    private StringBuilder inputString;

    @Before
    public void setup() {
        inputString = new StringBuilder("helloworld");
        stringOperations = new StringOperations();
    }

    @Test
    public void testVerifyOperation() {
        stringOperations.replaceOperation(inputString, 0, 'a');
        stringOperations.replaceOperation(inputString, 7, 'x');
        Assert.assertEquals("aellowoxld", inputString.toString());

        char[] result1 = inputString.toString().toCharArray();

        stringOperations.reverseOperation(inputString, 1, 2);
        stringOperations.reverseOperation(inputString, 1, 3);
        Assert.assertEquals("alelowoxld", inputString.toString());

        char[] result2 = inputString.toString().toCharArray();

        int count = 0;
        for (int i = 0; i < result1.length; i++) {
            if (result1[i] == result2[i]) {
                count++;
            }
        }

        Assert.assertEquals(8, count);


    }
}