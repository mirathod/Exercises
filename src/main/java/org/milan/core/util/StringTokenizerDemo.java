package org.milan.core.util;

import java.util.StringTokenizer;

/**
 * Example of StringTokenizer
 *
 * @author Milan Rathod
 */
public class StringTokenizerDemo {


    public static void main(String[] s) {

        String str = "name=Milan;surname=Rathod;College=LD";
        StringTokenizer d = new StringTokenizer(str, "=;");
        System.out.println(d.countTokens());

        while (d.hasMoreTokens()) {
            System.out.print(d.nextToken() + ":");

            System.out.println(d.nextToken());
        }
    }

}
