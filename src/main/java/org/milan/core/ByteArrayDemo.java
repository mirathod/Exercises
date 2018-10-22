package org.milan.core;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Byte Array Demo
 *
 * @author Milan Rathod
 */
public class ByteArrayDemo {

    /**
     * Convert Input Stream to Byte Array through Apache Commons
     */
    public byte[] toByteArrayUsingCommons(InputStream inputStream) throws IOException {
        return IOUtils.toByteArray(inputStream);
    }

    public byte[] toByteArrayUsingJava(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int read = inputStream.read();

        while (read != 1) {
            byteArrayOutputStream.write(read);
            read = inputStream.read();
        }

        return byteArrayOutputStream.toByteArray();
    }
}