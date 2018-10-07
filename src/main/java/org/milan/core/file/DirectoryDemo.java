package org.milan.core.file;

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

        File w = new File(path);
        return w.mkdir();

    }

    /**
     * Create a Single Directory & all its sub-directories
     *
     * @return true if operation succeed, otherwise false
     */
    public boolean createDirectories(String path) {

        File f = new File(path);
        return f.mkdirs();

    }

    public static void main(String[] a) {
        File f = new File("C:/Demo");

        if (f.exists()) {
            String[] filelist = f.list();
            for (String file : filelist) {
                System.out.println(file);
            }
        }

        File f2 = new File("C:/Demo/D1");
        CustomFileNameFilter customFileNameFilter = new CustomFileNameFilter("txt");
        String[] list2 = f2.list(customFileNameFilter);

        for (String file : list2) {
            System.out.println(file);
        }
    }

}
