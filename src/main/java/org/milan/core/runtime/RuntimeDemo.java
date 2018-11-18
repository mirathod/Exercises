package org.milan.core.runtime;

import java.io.IOException;

/**
 * @author Milan Rathod
 */
public class RuntimeDemo {
    public static void main(String[] s) {
        Runtime r = Runtime.getRuntime();

        try {

            r.exec("Notepad");
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

}
