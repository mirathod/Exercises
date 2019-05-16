package org.milan.core.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link StringSpacesReplacement}
 *
 * @author Milan Rathod
 */
public class StringSpacesReplacementTest {

    @Test
    public void testReplaceSpaces() {
        String input = "I am Sumit Jain";
        StringSpacesReplacement spacesReplacement = new StringSpacesReplacement();

        Assert.assertEquals("I%20am%20Sumit%20Jain", spacesReplacement.replaceSpaces(input));
    }
}