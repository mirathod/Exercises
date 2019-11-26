package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link ElementSameAsIndex}
 *
 * @author Milan Rathod
 */
public class ElementSameAsIndexTest {

    @Test
    public void findIndex() {
        ElementSameAsIndex elementSameAsIndex = new ElementSameAsIndex();

        int result = elementSameAsIndex.findIndex(new int[]{-4, -2, 1, 2, 3, 5, 9});

        Assert.assertEquals(5, result);
    }
}