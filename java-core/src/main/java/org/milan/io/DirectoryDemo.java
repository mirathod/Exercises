package org.milan.io;

import org.milan.util.FileUtil;

import java.io.File;

/**
 * Directory Demo
 *
 * @author Milan Rathod
 */
public class DirectoryDemo {

    /**
     * Create a Single Directory
     *
     * @return true if operation succeed, otherwise false
     */
    public boolean createDirectory(String path) {
        File file = new File(path);
        return file.mkdir();
    }

    /**
     * Create a Single Directory & all its sub-directories
     *
     * @return true if operation succeed, otherwise false
     */
    public boolean createDirectories(String path) {
        File file = new File(path);
        return file.mkdirs();
    }

    public static void main(String[] a) {
        DirectoryDemo directoryDemo = new DirectoryDemo();

        String directoryPath = "C:" + File.separator + "testDir";

        directoryDemo.createDirectory(directoryPath);

        File directory = new File(directoryPath);

        long lastModified = directory.lastModified();

        System.out.println("Last Modified Time:-" + FileUtil.format(lastModified));

    }
}
