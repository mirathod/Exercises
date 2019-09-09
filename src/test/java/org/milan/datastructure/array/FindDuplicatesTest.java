package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Test Class for {@link FindDuplicates}
 *
 * @author Milan Rathod
 */
public class FindDuplicatesTest {

    @Test
    public void testFind() {
        int[] inputArray = {1, 2, 3, 0, 4, 2, 4, 0};
        FindDuplicates findDuplicates = new FindDuplicates();
        List<Integer> outputList = findDuplicates.find(inputArray);

        Assert.assertEquals(3, outputList.size());
    }
}