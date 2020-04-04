package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for {@link LastOccurrence}
 *
 * @author Milan Rathod
 */
public class LastOccurrenceTest {

    @Test
    public void testGet() {
        LastOccurrence lastOccurrence = new LastOccurrence();

        int result = lastOccurrence.get(new int[]{1, 2, 3, 4, 1}, 1);

        Assert.assertEquals(5, result);
    }
}