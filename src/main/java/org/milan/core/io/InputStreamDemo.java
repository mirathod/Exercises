package org.milan.core.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Input Stream Demo
 *
 * @author Milan Rathod
 */
public class InputStreamDemo {

    public static void main(String[] a) {
        int c = 0;
        try {

            FileOutputStream o = new FileOutputStream("C:/output.txt");
            BufferedOutputStream bo = new BufferedOutputStream(o);
            String str = "L.D is excellent college\n";
            byte[] arr = str.getBytes();
            bo.write(arr);
            bo.flush();
            bo.close();
            o.close();

            FileInputStream i = new FileInputStream("C:/output.txt");
            BufferedInputStream bi = new BufferedInputStream(i);

            while ((c = bi.read()) != -1) {
                System.out.print((char) c);
            }

            bi.close();
            i.close();
        } catch (Exception e) {

        }

    }
}
