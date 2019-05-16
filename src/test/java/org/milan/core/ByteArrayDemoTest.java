package org.milan.core;

import org.junit.Assert;
import org.junit.Test;
import org.milan.core.io.ByteArrayDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Test Class for {@link ByteArrayDemo}
 *
 * @author Milan Rathod
 */
public class ByteArrayDemoTest {

    private static final String FILE_PATH = "C:" + File.separator + "testDir" + File.separator + "ByteArray.txt";

    @Test
    public void testToByteArrayUsingCommons() throws IOException {
        ByteArrayDemo byteArrayDemo = new ByteArrayDemo();
        int result = byteArrayDemo.toByteArrayUsingCommons(new FileInputStream(FILE_PATH)).length;
        Assert.assertEquals(15, result);
    }

    @Test
    public void testToByteArrayUsingJava() throws IOException {
        ByteArrayDemo byteArrayDemo = new ByteArrayDemo();
        int result = byteArrayDemo.toByteArrayUsingJava(new FileInputStream(FILE_PATH)).length;
        Assert.assertEquals(15, result);

    }
}