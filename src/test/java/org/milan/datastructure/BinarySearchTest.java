package org.milan.datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class BinarySearchTest {

    @Test
    public void binarySearch() {
        int a[] = {2, 4, 6, 8, 9, 12, 15, 18};
        int search = new BinarySearch().binarySearch(a, 12);

        Assert.assertEquals(search, 5);
    }
}