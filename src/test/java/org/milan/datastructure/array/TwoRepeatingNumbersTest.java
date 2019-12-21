package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link TwoRepeatingNumbers}
 *
 * @author Milan Rathod
 */
public class TwoRepeatingNumbersTest {

    private TwoRepeatingNumbers twoRepeatingNumbers;

    private int[] inputArray;

    @Before
    public void setUp() {
        twoRepeatingNumbers = new TwoRepeatingNumbers();

        inputArray = new int[]{4, 2, 4, 5, 2, 3, 1};
    }

    @Test
    public void findUsingCountArray() {
        int[] result = twoRepeatingNumbers.findUsingCountArray(inputArray);

        Assert.assertArrayEquals(new int[]{4, 2}, result);
    }

    @Test
    public void findUsingEquation() {
        int[] result = twoRepeatingNumbers.findUsingEquation(inputArray);

        Assert.assertArrayEquals(new int[]{4, 2}, result);
    }

    @Test
    public void findUsingAbs() {
        int[] result = twoRepeatingNumbers.findUsingAbs(inputArray);

        Assert.assertArrayEquals(new int[]{2, 4}, result);
    }
}