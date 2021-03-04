package org.milan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.milan.io.ByteArrayDemo;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Class for {@link ByteArrayDemo}
 *
 * @author Milan Rathod
 */
class ByteArrayDemoTest {

    private InputStream inputStream;

    private ByteArrayDemo byteArrayDemo;

    @BeforeEach
    void setup() {
        inputStream = getClass().getClassLoader().getResourceAsStream("ByteArray.txt");

        byteArrayDemo = new ByteArrayDemo();
    }

    @Test
    void testToByteArrayUsingCommons() throws IOException {
        byte[] result = byteArrayDemo.toByteArrayUsingCommons(inputStream);
        assertEquals(15, result.length);
    }

    @Test
    void testToByteArrayUsingJava() throws IOException {
        byte[] result = byteArrayDemo.toByteArrayUsingJava(inputStream);
        assertEquals(15, result.length);
    }
}