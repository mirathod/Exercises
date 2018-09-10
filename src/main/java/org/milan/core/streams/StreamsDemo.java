package org.milan.core.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class StreamsDemo {

    public List<Integer> mapAndFilter(List<String> inputList) {
        return inputList.stream().map(Integer::valueOf)
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());
    }

    public static void main (String[] args) {
        List<String> inputList = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<Integer> integers = new StreamsDemo().mapAndFilter(inputList);
        System.out.print(integers);
    }
}
