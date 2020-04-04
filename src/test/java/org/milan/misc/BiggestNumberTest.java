package org.milan.misc;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Test class for {@link BiggestNumber}
 *
 * @author Milan Rathod
 */
public class BiggestNumberTest {

    @Test
    public void testFind() {
        BiggestNumber biggestNumber = new BiggestNumber();

        BigInteger result = biggestNumber.find(new int[]{1, 34, 3, 98, 9, 76, 45, 4, 12, 121});

        Assert.assertEquals(new BigInteger("99876454343121211"), result);
    }
}