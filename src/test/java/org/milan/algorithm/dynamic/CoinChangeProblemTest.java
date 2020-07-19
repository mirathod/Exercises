package org.milan.algorithm.dynamic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link CoinChangeProblem}
 *
 * @author Milan Rathod
 */
public class CoinChangeProblemTest {

    private CoinChangeProblem coinChangeProblem;

    @Before
    public void setUp() {
        coinChangeProblem = new CoinChangeProblem();
    }

    @Test
    public void testCount() {
        int[] coins = new int[]{1, 2, 3};

        int n = 4;

        int result = coinChangeProblem.count(coins, coins.length, n);

        Assert.assertEquals(4, result);
    }

    @Test
    public void testCountV2() {
        int[] coins = new int[]{1, 2, 3};

        int n = 4;

        int result = coinChangeProblem.countV2(coins, coins.length, n);

        Assert.assertEquals(4, result);
    }
}