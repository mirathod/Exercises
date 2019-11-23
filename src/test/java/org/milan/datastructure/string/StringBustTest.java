package org.milan.datastructure.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Test class for {@link StringBust}
 *
 * @author Milan Rathod
 */
public class StringBustTest {

    @Test
    public void testCompute() {
        List<String> input = Arrays.asList("a", "b", "c", "d", "e", "e", "e", "e", "d", "d", "c", "b", "f", "g", "f");

        StringBust stringBust = new StringBust();

        List<String> result = stringBust.compute(input, 3);
    }
}