package org.milan.streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for all use cases of {@link java.util.stream.Stream}
 *
 * @author Milan Rathod
 */
class StreamsTest {

    @Test
    void givenInfiniteStream_whenUseIntermediateLimitMethod_thenShouldTerminateInFiniteTime() {
        //given
        Stream<Integer> infiniteStream = Stream.iterate(0, i -> i + 2);

        //when
        List<Integer> collect = infiniteStream
                .limit(10)
                .collect(Collectors.toList());

        //then
        assertEquals(collect, Arrays.asList(0, 2, 4, 6, 8, 10, 12, 14, 16, 18));
    }

    @Test
    void givenInfiniteStreamOfRandomInts_whenUseLimit_shouldTerminateInFiniteTime() {
        //given
        Supplier<UUID> randomUUIDSupplier = UUID::randomUUID;
        Stream<UUID> infiniteStreamOfRandomUUID = Stream.generate(randomUUIDSupplier);

        //when
        List<UUID> randomInts = infiniteStreamOfRandomUUID
                .skip(10)
                .limit(10)
                .collect(Collectors.toList());

        //then
        assertEquals(randomInts.size(), 10);
    }

    @Test
    void doWhileStreamReplacement() {
        List<Integer> outputList = new ArrayList<>();

        // Old way
        int i = 0;
        while (i < 10) {
            outputList.add(i);
            i++;
        }

        assertEquals(outputList, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        // Stream way
        Stream<Integer> integers = Stream
                .iterate(0, j -> j + 1);
        outputList = integers
                .limit(10)
                .collect(Collectors.toList());

        assertEquals(outputList, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

}