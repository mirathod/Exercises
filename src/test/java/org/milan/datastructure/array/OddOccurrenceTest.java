package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link OddOccurrence}
 *
 * @author Milan Rathod
 */
public class OddOccurrenceTest {

    private OddOccurrence oddOccurrence;

    private int[] inputArray;

    @Before
    public void setUp() {
        oddOccurrence = new OddOccurrence();

        inputArray = new int[]{1, 2, 3, 2, 3, 1, 3};
    }

    @Test
    public void findUsingHashing() {
        int result = oddOccurrence.findUsingHashing(inputArray);

        Assert.assertEquals(3, result);
    }

    @Test
    public void findUsingXOR() {
        int result = oddOccurrence.findUsingXOR(inputArray);

        Assert.assertEquals(3, result);
    }
}