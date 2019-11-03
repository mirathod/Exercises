package org.milan.datastructure.subsequence;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test Class for {@link SubSequenceDivisbleBy}
 *
 * @author Milan Rathod
 */
public class SubSequenceDivisbleByTest {

    @Test
    public void testCount() {
        int result = new SubSequenceDivisbleBy().count("330", 6);
        Assert.assertEquals(4, result);
    }
}