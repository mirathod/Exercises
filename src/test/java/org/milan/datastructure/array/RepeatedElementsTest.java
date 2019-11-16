package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link RepeatedElements}
 *
 * @author Milan Rathod
 */
public class RepeatedElementsTest {

    private RepeatedElements repeatedElements;

    private int[] inputArray;

    @Before
    public void setup() {
        repeatedElements = new RepeatedElements();

        inputArray = new int[]{4, 2, 4, 5, 2, 3, 1};
    }

    @Test
    public void testGetAll() {
        int[] result = repeatedElements.getAll(inputArray);

        Assert.assertArrayEquals(new int[]{4, 2}, result);
    }

    @Test
    public void testGetAllV2() {
        int[] result = repeatedElements.getAllV2(inputArray);

        Assert.assertArrayEquals(new int[]{4, 2}, result);
    }
}