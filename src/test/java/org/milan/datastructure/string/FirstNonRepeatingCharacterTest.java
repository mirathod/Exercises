package org.milan.datastructure.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link FirstNonRepeatingCharacter}
 *
 * @author Milan Rathod
 */
public class FirstNonRepeatingCharacterTest {

    private FirstNonRepeatingCharacter firstNonRepeatingCharacter;

    @Before
    public void setUp() {
        firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
    }

    @Test
    public void testFind() {
        int result = firstNonRepeatingCharacter.find("geeksforgeeks");

        Assert.assertEquals(5, result);
    }
}