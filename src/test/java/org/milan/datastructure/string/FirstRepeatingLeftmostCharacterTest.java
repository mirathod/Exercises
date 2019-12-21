package org.milan.datastructure.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link FirstRepeatingLeftmostCharacter}
 *
 * @author Milan Rathod
 */
public class FirstRepeatingLeftmostCharacterTest {

    @Test
    public void testFind() {
        FirstRepeatingLeftmostCharacter firstRepeatingLeftmostCharacter = new FirstRepeatingLeftmostCharacter();

        char result = firstRepeatingLeftmostCharacter.find("geeksforgeeks");

        Assert.assertEquals('g', result);
    }
}