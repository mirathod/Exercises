package org.milan.core.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * File Reader Demo
 *
 * @author Milan Rathod
 */
public class FileReaderDemo {
    public static void main(String[] a) {

        try {
            FileWriter w = new FileWriter("C:/output.txt"); // low level stream
            BufferedWriter bw = new BufferedWriter(w); // high level stream
            bw.write("LD is the best college");
            bw.flush();
            bw.close();
            w.close();

            FileReader r = new FileReader("C:/output.txt");
            BufferedReader br = new BufferedReader(r);

            System.out.println(br.readLine());

            br.close();
            r.close();
        } catch (Exception e) {

            System.out.println(e.toString());
        }
    }
}