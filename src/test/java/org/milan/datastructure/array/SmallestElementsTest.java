package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Test;
import org.milan.datastructure.array.SmallestElements;

import java.util.List;

/**
 * Test Class for {@link SmallestElements}
 *
 * @author Milan Rathod
 */
public class SmallestElementsTest {

    @Test
    public void testFindSmallestElements() {
        int[] inputArray = {12, 13, 1, 10, 34, 1};
        SmallestElements smallestElements = new SmallestElements();
        List<Integer> result = smallestElements.findSmallestElements(inputArray);

        Assert.assertEquals(1, result.get(0).intValue());
        Assert.assertEquals(10, result.get(1).intValue());
    }
}