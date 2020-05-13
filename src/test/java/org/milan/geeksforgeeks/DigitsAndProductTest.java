package org.milan.geeksforgeeks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link DigitsAndProduct}
 *
 * @author Milan Rathod
 */
public class DigitsAndProductTest {

    public void test() {

        int year = 1111;

    }

    @Test
    public void testCount() {
        DigitsAndProduct digitsAndProduct = new DigitsAndProduct();

        int result = digitsAndProduct.count(10, 12, 2);

        Assert.assertEquals(1, result);

        result = digitsAndProduct.count(5, 15, 2);

        Assert.assertEquals(9, result);
    }
}