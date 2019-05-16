package org.milan.core.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link TextJustification}
 *
 * @author Milan Rathod
 */
public class TextJustificationTest {

    @Test
    public void testJustify() {
        TextJustification textJustification = new TextJustification();

        String[] words = {"This", "is", "a", "text", "justification", "problem", "in", "tutorial", "horizon"};

        String result = textJustification.justify(words, 25, 0);

        Assert.assertEquals(3, result.split("\n").length);
    }

}