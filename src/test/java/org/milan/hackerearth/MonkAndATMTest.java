package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link MonkAndATM}
 *
 * @author Milan Rathod
 */
public class MonkAndATMTest {

    @Test
    public void testCheckPin() {
        MonkAndATM monkAndATM = new MonkAndATM();

        int result = monkAndATM.checkPin(48);

        Assert.assertEquals(result, 8);
    }
}