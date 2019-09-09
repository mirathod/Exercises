package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Test;
import org.milan.datastructure.array.DeleteDuplicates;

import java.util.Arrays;
import java.util.Objects;

/**
 * Test Class for {@link DeleteDuplicates}
 *
 * @author Milan Rathod
 */
public class DeleteDuplicatesTest {

    @Test
    public void testReturnUniqueNumbers() {
        DeleteDuplicates removeDup = new DeleteDuplicates();
        Integer[] original = {11, 2, 4, 2, 3};
        Integer[] finalValue = new Integer[original.length + 1];

        // method to return unique values
        Integer[] unique = removeDup.returnUniqueNumbers(original, finalValue);

        Assert.assertEquals(4, Arrays.stream(unique).filter(Objects::nonNull).count());
    }
}