package org.milan.datastructure.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link ElectionWinner}
 *
 * @author Milan Rathod
 */
public class ElectionWinnerTest {

    @Test
    public void find() {
        String[] votes = {"john", "johnny", "jackie", "jamie", "jamie", "john"};

        ElectionWinner electionWinner = new ElectionWinner();

        Assert.assertEquals("jamie", electionWinner.find(votes));
    }
}