package org.milan.core.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link StringsCompression}
 *
 * @author Milan Rathod
 */
public class StringsCompressionTest {

    @Test
    public void testCompression() {
        StringsCompression stringsCompression = new StringsCompression();

        String input = "ssssuuuummmmmmiiiittttttttttttt";

        Assert.assertEquals("s4u4m6i4t13", stringsCompression.compression(input));

        input = "Jaain";

        Assert.assertEquals("Jaain", stringsCompression.compression(input));
    }
}