package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link MissingNumber}
 *
 * @author Milan Rathod
 */
public class MissingNumberTest {

    private MissingNumber missingNumber;

    private int[] inputArray;

    @Before
    public void setup() {
        missingNumber = new MissingNumber();

        inputArray = new int[]{1, 2, 4, 5, 6};
    }

    @Test
    public void testFindUsingSum() {
        int result = missingNumber.findUsingSum(inputArray);

        Assert.assertEquals(3, result);
    }

    @Test
    public void testFindUsingSubtract() {
        int result = missingNumber.findUsingSubtract(inputArray);

        Assert.assertEquals(3, result);
    }

    @Test
    public void testFindUsingXOR() {
        int result = missingNumber.findUsingXOR(inputArray);

        Assert.assertEquals(3, result);
    }
}