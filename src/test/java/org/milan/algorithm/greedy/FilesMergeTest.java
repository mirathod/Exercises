package org.milan.algorithm.greedy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link FilesMerge}
 *
 * @author Milan Rathod
 */
public class FilesMergeTest {

    @Test
    public void testMerge() {
        FilesMerge filesMerge = new FilesMerge();

        int result = filesMerge.merge(new int[]{2, 3, 4, 5, 6, 7});

        Assert.assertEquals(68, result);
    }
}