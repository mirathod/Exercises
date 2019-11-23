package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class {@link BytelandianGoldCoins}
 *
 * @author Milan Rathod
 */
public class BytelandianGoldCoinsTest {

    @Test
    public void testReplaceCoins() {
        BytelandianGoldCoins bytelandianGoldCoins = new BytelandianGoldCoins();
        long result = bytelandianGoldCoins.replaceCoins(474788800);

        Assert.assertEquals(1901257550, result);
    }
}