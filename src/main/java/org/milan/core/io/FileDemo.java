package org.milan.core.io;

import org.milan.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

/**
 * File Class Demo
 *
 * @author Milan Rathod
 */
public class FileDemo {

    public static void main(String[] a) throws IOException {
        File f = new File("C:" + File.separator + "test" + File.separator + "FileDemo");

        if (!f.exists()) {
            f.createNewFile();
        }
        System.out.println("Writable:-" + f.canWrite());
        System.out.println("Name:-" + f.getName());
        System.out.println("Readable:-" + f.canRead());
        System.out.println("Executable:-" + f.canExecute());
        System.out.println("Free Space:-" + f.getFreeSpace());
        System.out.println("Is it a Directory:-" + f.isDirectory());
        System.out.println("Is it hidden ?:-" + f.isHidden());
        System.out.println("Length:-" + f.length());
        System.out.println("Last Modified Time:-" + f.lastModified());

        // Java 7 way to get Last Modified Time
        Path path = Paths.get("C:" + File.separator + "test" + File.separator + "FileDemo");

        FileTime fileTime = Files.getLastModifiedTime(path, LinkOption.NOFOLLOW_LINKS);

        System.out.println("Last Modified Time using java 7 apis:-" + FileUtil.format(fileTime.toMillis()));
    }
}
