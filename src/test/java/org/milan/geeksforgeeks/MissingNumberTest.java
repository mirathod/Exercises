package org.milan.geeksforgeeks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link MissingNumber}
 *
 * @author Milan Rathod
 */
public class MissingNumberTest {

    @Test
    public void testFindMissingNumber() {
        MissingNumber missingNumber = new MissingNumber();

        int[] inputArray = {1, 2, 4, 5, 6};

        // XOR Method
        int result = missingNumber.findMissingNumber(inputArray);

        Assert.assertEquals(3, result);

        // Sum Method
        result = missingNumber.findMissingNumber(inputArray, inputArray.length);

        Assert.assertEquals(3, result);
    }
}