package org.milan.datastructure.subsequence;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link SubSequenceOf}
 *
 * @author Milan Rathod
 */
public class SubSequenceOfTest {

    @Test
    public void testIsSubSequence() {
        SubSequenceOf subSequenceOf = new SubSequenceOf();
        Assert.assertTrue(subSequenceOf.isSubSequence("AXY", "ADXCPY", 3, 6));

        Assert.assertFalse(subSequenceOf.isSubSequence("AXY", "YADXCP", 3, 6));
    }
}