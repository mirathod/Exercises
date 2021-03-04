package org.milan.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Example of {@link java.io.PipedInputStream} and {@link java.io.PipedOutputStream}
 *
 * @author Milan Rathod
 */
public class PipesDemo {

    public static void main(String[] args) throws IOException {
        final PipedOutputStream pipedOutputStream = new PipedOutputStream();

        final PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        Thread thread1 = new Thread(() -> {
            try {
                pipedOutputStream.write("Test pipe!".getBytes());
                pipedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            int data;
            try {
                while ((data = pipedInputStream.read()) != -1) {
                    System.out.print((char) data);
                }
                pipedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}
