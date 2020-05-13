package org.milan.misc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link Complement}
 *
 * @author Milan Rathod
 */
public class ComplementTest {

    private Complement complement;

    @Before
    public void init() {
        complement = new Complement();
    }

    @Test
    public void testOnesComplement() {
        Assert.assertEquals("0011", complement.onesComplement("1100"));
    }

    @Test
    public void testTwosComplement() {
        Assert.assertEquals("0100", complement.twosComplement("1100"));

        Assert.assertEquals("01001", complement.twosComplement("10111"));
    }
}