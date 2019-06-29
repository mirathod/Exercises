package org.milan.core.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link UpperCaseToEnd}
 *
 * @author Milan Rathod
 */
public class UpperCaseToEndTest {

    @Test
    public void move() {
        UpperCaseToEnd upperCaseToEnd = new UpperCaseToEnd();

        String result = upperCaseToEnd.move("Geeksforgeeks A Computer Science Portal for Geeks!!");

        Assert.assertEquals("eeksforgeeks  omputer cience ortal for eeks!!GACSPG", result);
    }
}