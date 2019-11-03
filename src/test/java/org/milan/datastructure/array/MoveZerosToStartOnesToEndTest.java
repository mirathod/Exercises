package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link MoveZerosToStartOnesToEnd}
 *
 * @author Milan Rathod
 */
public class MoveZerosToStartOnesToEndTest {

    @Test
    public void testMove() {
        int[] testArray = new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};

        MoveZerosToStartOnesToEnd moveZerosToStartOnesToEnd = new MoveZerosToStartOnesToEnd();

        moveZerosToStartOnesToEnd.move(testArray);

        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 9, 8, 4, 2, 7, 6, 1}, testArray);

        testArray = new int[]{1, 2, 0, 4, 3, 0, 5, 0};

        moveZerosToStartOnesToEnd.move(testArray);

        Assert.assertArrayEquals(new int[]{0, 0, 0, 2, 4, 3, 5, 1}, testArray);

        testArray = new int[]{1, 2, 0, 0, 0, 3, 6};

        moveZerosToStartOnesToEnd.move(testArray);

        Assert.assertArrayEquals(new int[]{0, 0, 0, 2, 3, 6, 1}, testArray);
    }
}