package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link FirstRepeatingElement}
 *
 * @author Milan Rathod
 */
public class FirstRepeatingElementTest {

    private FirstRepeatingElement firstRepeatingElement;

    @Before
    public void setUp() {
        firstRepeatingElement = new FirstRepeatingElement();
    }

    @Test
    public void testFind_RepeatingElementExists() {
        int[] inputArray = new int[]{10, 5, 3, 4, 3, 5, 6};

        int result = firstRepeatingElement.find(inputArray);

        Assert.assertEquals(5, result);
    }

    @Test
    public void testFind_RepeatingElementNotExists() {
        int[] inputArray = new int[]{10, 5, 1, 4, 3, 2, 6};

        int result = firstRepeatingElement.find(inputArray);

        Assert.assertEquals(-1, result);
    }
}