package org.milan.core.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

/**
 * Hidden File Example
 *
 * @author Milan Rathod
 */
public class HiddenFileDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("C:" + File.separator + "testDir" + File.separator + "test.xlsx");

        // Before JDK 7
        setHiddenProperty(file);

        // In JDK 7
        setHiddenProperty();

        System.out.println(file.isHidden());

    }

    private static void setHiddenProperty(File file) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("attrib +H " + file.getPath());
        process.waitFor();
    }

    private static void setHiddenProperty() throws IOException {
        Path path = FileSystems.getDefault().getPath("C:" + File.separator + "testDir", "test.txt");
        Boolean flag = (Boolean) Files.getAttribute(path, "dos:hidden", LinkOption.NOFOLLOW_LINKS);

        if (flag != null && !flag) {
            Files.setAttribute(path, "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
        }
    }
}
