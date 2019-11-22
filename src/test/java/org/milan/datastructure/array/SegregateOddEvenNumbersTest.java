package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link SegregateOddEvenNumbers}
 *
 * @author Milan Rathod
 */
public class SegregateOddEvenNumbersTest {

    @Test
    public void testSegregate() {
        SegregateOddEvenNumbers segregateOddEvenNumbers = new SegregateOddEvenNumbers();

        int[] input = new int[]{12, 34, 45, 9, 8, 90, 3};

        segregateOddEvenNumbers.segregate(input);

        Assert.assertArrayEquals(new int[]{12, 34, 90, 8, 9, 45, 3}, input);
    }
}