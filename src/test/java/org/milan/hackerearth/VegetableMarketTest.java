package org.milan.hackerearth;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Test class for {@link VegetableMarket}
 *
 * @author Milan Rathod
 */
public class VegetableMarketTest {

    @Test
    public void testMinimumToBuy() {
        VegetableMarket vegetableMarket = new VegetableMarket();
        int result = vegetableMarket.minimumToBuy(List.of(3, 8, 4, 1, 7), 22);

        Assert.assertEquals(7, result);

        result = vegetableMarket.minimumToBuy(List.of(3, 8, 4, 1, 7), 25);

        Assert.assertEquals(-1, result);
    }
}