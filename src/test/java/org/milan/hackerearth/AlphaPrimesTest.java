package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link AlphaPrimes}
 *
 * @author Milan Rathod
 */
public class AlphaPrimesTest {

    @Test
    public void testGetCount() {
        AlphaPrimes alphaPrimes = new AlphaPrimes();
        int count = alphaPrimes.getCount(110, 114);

        Assert.assertEquals(3, count);
    }
}