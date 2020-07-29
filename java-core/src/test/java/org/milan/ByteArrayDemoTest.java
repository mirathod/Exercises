package org.milan;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.milan.io.ByteArrayDemo;

import java.io.IOException;
import java.io.InputStream;

/**
 * Test Class for {@link ByteArrayDemo}
 *
 * @author Milan Rathod
 */
public class ByteArrayDemoTest {

    private InputStream inputStream;

    private ByteArrayDemo byteArrayDemo;

    @Before
    public void setup() {
        inputStream = getClass().getClassLoader().getResourceAsStream("ByteArray.txt");

        byteArrayDemo = new ByteArrayDemo();
    }

    @Test
    public void testToByteArrayUsingCommons() throws IOException {
        byte[] result = byteArrayDemo.toByteArrayUsingCommons(inputStream);
        Assert.assertEquals(15, result.length);
    }

    @Test
    public void testToByteArrayUsingJava() throws IOException {
        byte[] result = byteArrayDemo.toByteArrayUsingJava(inputStream);
        Assert.assertEquals(15, result.length);
    }
}