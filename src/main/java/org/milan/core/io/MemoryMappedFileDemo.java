package org.milan.core.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Example of Memory Mapped File
 *
 * @author Milan Rathod
 */
public class MemoryMappedFileDemo {

    private static final String FILE_PATH = "C:" + File.separator + "test" + File.separator + "random.txt";

    private static final int COUNT = 10485760;

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(FILE_PATH, "rw");

        // Mapping a file to memory
        MappedByteBuffer out = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, COUNT);

        for (int i = 0; i < COUNT; i++) {
            out.put((byte) 'A');
        }

        System.out.println("Writing to Memory Mapped File is completed");

        //reading from memory file in Java
        for (int i = 0; i < 10; i++) {
            System.out.print((char) out.get(i));
        }

        System.out.println("Reading from Memory Mapped File is completed");

    }
}
