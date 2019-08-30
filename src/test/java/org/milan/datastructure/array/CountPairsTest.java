package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Test Class for {@link CountPairs}
 *
 * @author Milan Rathod
 */
public class CountPairsTest {

    private CountPairs countPairs;

    @Test
    public void countPairs() {
        countPairs = new CountPairs();

        int result = countPairs.count(List.of(1, 3, 46, 1, 3, 9), 47);

        Assert.assertEquals(1, result);
    }
}