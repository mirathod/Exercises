package org.milan.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link StudentWithMaxAvg}
 *
 * @author Milan Rathod
 */
public class StudentWithMaxAvgTest {

    @Test
    public void testFind() {
        String[][] arr = {{"Bob", "87"}, {"Mike", "35"}, {"Bob", "52"}, {"Jason", "35"}, {"Mike", "55"}, {"Jessica", "99"}};

        StudentWithMaxAvg studentWithMaxAvg = new StudentWithMaxAvg();

        int result = studentWithMaxAvg.find(arr);

        Assert.assertEquals(99, result);
    }
}