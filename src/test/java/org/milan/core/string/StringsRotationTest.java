package org.milan.core.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link StringsRotation}
 *
 * @author Milan Rathod
 */
public class StringsRotationTest {

    @Test
    public void isRotated() {
        StringsRotation stringsRotation = new StringsRotation();

        String s1 = "sumitjain";
        String s2 = "tjainsumi";

        Assert.assertTrue(stringsRotation.isRotated(s1, s2));
    }
}