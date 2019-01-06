package org.milan.geeksforgeeks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class SurvivalTest {

    @Test
    public void buyFoodDays() {
        Survival survival = new Survival();
        int result = survival.buyFoodDays(16, 10, 2);

        Assert.assertEquals(2, result);

    }
}