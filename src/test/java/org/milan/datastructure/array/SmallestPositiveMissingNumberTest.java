package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link SmallestPositiveMissingNumber}
 *
 * @author Milan Rathod
 */
public class SmallestPositiveMissingNumberTest {

    private SmallestPositiveMissingNumber smallestPositiveMissingNumber;

    private int[] arr;

    @Before
    public void setUp() {
        arr = new int[]{0, -1, -5, -10, 1, 2, 3, 4, 5};

        smallestPositiveMissingNumber = new SmallestPositiveMissingNumber();
    }

    @Test
    public void testFind() {
        int result = smallestPositiveMissingNumber.find(arr);

        Assert.assertEquals(6, result);
    }

    @Test
    public void testFindV2() {
        int result = smallestPositiveMissingNumber.findV2(arr);

        Assert.assertEquals(6, result);
    }
}