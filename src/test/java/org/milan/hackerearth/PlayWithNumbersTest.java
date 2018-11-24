package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link PlayWithNumbers}
 *
 * @author Milan Rathod
 */
public class PlayWithNumbersTest {

    @Test
    public void findMeanByCumulativeSum() {
        PlayWithNumbers playWithNumbers = new PlayWithNumbers();
        long result = playWithNumbers.findMeanByCumulativeSum(new int[]{1, 2, 3, 4, 5}, 2, 5);

        Assert.assertEquals(3, result);
    }

    @Test
    public void findMean() {
        PlayWithNumbers playWithNumbers = new PlayWithNumbers();
        int result = playWithNumbers.findMean(new int[]{1, 2, 3, 4, 5}, 2, 5);

        Assert.assertEquals(3, result);
    }
}