package org.milan.datastructure.heap;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link ConvertMin2Max}
 *
 * @author Milan Rathod
 */
public class ConvertMin2MaxTest {

    @Test
    public void testConvert() {
        int[] minHeap = new int[]{3, 5, 9, 6, 8, 20, 10, 12, 18, 9};

        ConvertMin2Max convertMin2Max = new ConvertMin2Max();

        int[] maxHeap = convertMin2Max.convert(minHeap);

        Assert.assertArrayEquals(new int[]{20, 18, 10, 12, 9, 9, 3, 5, 6, 8}, maxHeap);
    }
}