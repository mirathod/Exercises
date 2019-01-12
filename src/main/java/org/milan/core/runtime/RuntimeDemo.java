package org.milan.core.runtime;

import java.io.IOException;

/**
 * @author Milan Rathod
 */
public class RuntimeDemo {
    public static void main(String[] s) {
        Runtime runtime = Runtime.getRuntime();

        try {

            runtime.exec("Notepad");
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

}
