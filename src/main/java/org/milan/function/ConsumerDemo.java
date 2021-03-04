package org.milan.function;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milan Rathod
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("John");

        list.forEach(System.out::println);
    }
}
