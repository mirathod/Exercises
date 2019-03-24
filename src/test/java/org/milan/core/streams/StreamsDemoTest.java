package org.milan.core.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Test Class @see {@link StreamsDemo}
 *
 * @author Milan Rathod
 */
public class StreamsDemoTest {

    private StreamsDemo streamsDemo;

    @Before
    public void setup() {
        streamsDemo = new StreamsDemo();
    }

    @Test
    public void testMapAndFilter() {
        List<String> inputList = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<Integer> integers = streamsDemo.mapAndFilter(inputList);
        System.out.print(integers);
    }
}