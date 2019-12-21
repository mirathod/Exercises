package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link MajorityElement}
 *
 * @author Milan Rathod
 */
public class MajorityElementTest {

    private MajorityElement majorityElement;

    @Before
    public void setup() {
        majorityElement = new MajorityElement();
    }

    @Test
    public void testFind_Exists() {
        int[] arr = new int[]{1, 1, 2, 1, 3, 1, 5};

        int result = majorityElement.find(arr);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testFind_NotExists() {
        int[] arr = new int[]{1, 3, 3, 1, 2};

        int result = majorityElement.find(arr);

        Assert.assertEquals(-1, result);
    }

    @Test
    public void testFindV2_Exists() {
        int[] arr = new int[]{1, 1, 2, 1, 3, 1, 5};

        int result = majorityElement.findV2(arr);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testFindV2_NotExists() {
        int[] arr = new int[]{1, 3, 3, 1, 2};

        int result = majorityElement.findV2(arr);

        Assert.assertEquals(-1, result);
    }
}