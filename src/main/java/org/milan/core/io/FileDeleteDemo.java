package org.milan.core.io;

import java.io.File;

/**
 * File/Directory Deletion Example
 *
 * @author Milan Rathod
 */
public class FileDeleteDemo {

    public static void main(String[] args) {
        deleteDirectory(new File("C:" + File.separator + "testDir"));
    }

    /**
     * Delete non-empty directory
     */
    public static boolean deleteDirectory(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (int i = 0; i < files.length; i++) {
                boolean success = deleteDirectory(files[i]);
                if (!success) {
                    return false;
                }
            }
        }

        System.out.println("Removing File/Directory: " + directory.getName());
        return directory.delete();
    }

}
