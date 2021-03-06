package org.milan.misc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Base64 example
 *
 * @author Milan Rathod
 */
public class Base64Demo {

    public static void main(String[] args) {
        int n = 5;
        int s = (int) Math.pow(2, (int) (Math.log(n) / Math.log(2)));
        //System.out.println(s);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(1, 5);
        //System.out.println(list);
        String original = "Java is better than C";
        byte[] bytes = original.getBytes(StandardCharsets.UTF_8);
        String encodedString = java.util.Base64.getEncoder().encodeToString(bytes);
        System.out.println(original);
        System.out.println(encodedString);
        byte[] decodedString = java.util.Base64.getDecoder().decode(encodedString);
        String orig = new String(decodedString, StandardCharsets.UTF_8);
        System.out.println(orig);
    }

}


