package org.milan.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Example of {@link java.io.RandomAccessFile}
 *
 * @author Milan Rathod
 */
public class RandomAccessFileDemo {

    private static final String FILE_PATH = "C:" + File.separator + "test" + File.separator + "random.txt";

    public static void main(String[] args) {
        String data = "test data (1.0 - 1.1)";
        write(FILE_PATH, 10, data);

        String readData = read(FILE_PATH, 10);

        System.out.println(readData);
    }

    private static void write(String file, int position, String data) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

            // Move io pointer to specified position
            randomAccessFile.seek(position);

            // write data to io
            randomAccessFile.writeUTF(data);

            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String read(String file, int position) {
        String data = null;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

            // Move io pointer to specified position
            randomAccessFile.seek(position);

            // read data from io
            data = randomAccessFile.readUTF();

            randomAccessFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
