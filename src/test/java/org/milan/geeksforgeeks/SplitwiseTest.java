package org.milan.geeksforgeeks;

import org.junit.Test;

/**
 * Test Class for {@link Splitwise}
 *
 * @author Milan Rathod
 */
public class SplitwiseTest {

    @Test
    public void testSimplifyDebt() {
        // Input Graph describing debts of persons to each other
        int[][] input = {{0, 1000, 2000},
                {0, 0, 5000},
                {0, 0, 0}};

        Splitwise splitwise = new Splitwise();

        splitwise.simplifyDebt(input, 3);
    }
}