package org.milan.datastructure.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link FirstRepeatingCharacter}
 *
 * @author Milan Rathod
 */
public class FirstRepeatingCharacterTest {

    @Test
    public void testFind() {
        FirstRepeatingCharacter firstRepeatingCharacter = new FirstRepeatingCharacter();

        char result = firstRepeatingCharacter.find("geeksforgeeks");

        Assert.assertEquals('e', result);
    }
}