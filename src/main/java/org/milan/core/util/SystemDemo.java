package org.milan.core.util;

/**
 * System Class Utility methods
 *
 * @author Milan Rathod
 */
public class SystemDemo {

    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        System.out.println(currentDir);
    }
}
