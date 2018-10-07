package org.milan.core.streams;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Java 8 Streams Demo @see {@link java.util.stream.Streams}
 *
 * @author Milan Rathod
 */
public class StreamsDemo {

    public List<Integer> mapAndFilter(List<String> inputList) {

        return inputList.stream().map(Integer::valueOf)
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());
    }
}
