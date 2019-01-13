package org.milan.core.lambda;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Java 8 Lambda method reference sample
 *
 * @author Milan Rathod
 */
public class MethodReferenceDemo {

    public static void main(String[] args) {
        List<String> integerList = Lists.newArrayList("1", "2", "5", "3");

        // Normal way
        integerList.stream().sorted().forEach(s -> {
            System.out.println(s);
        });

        // using method reference
        integerList.stream().sorted().forEach(System.out::println);

        integerList.stream().sorted().forEach(String::valueOf);
    }
}
