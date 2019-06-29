package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link MoveZerosToEnd}
 *
 * @author Milan Rathod
 */
public class MoveZerosToEndTest {

    @Test
    public void move() {
        int[] testArray = new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};

        MoveZerosToEnd moveZerosToEnd = new MoveZerosToEnd();

        moveZerosToEnd.move(testArray);

        Assert.assertArrayEquals(new int[]{1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}, testArray);

        testArray = new int[]{1, 2, 0, 4, 3, 0, 5, 0};

        moveZerosToEnd.move(testArray);

        Assert.assertArrayEquals(new int[]{1, 2, 4, 3, 5, 0, 0, 0}, testArray);

        testArray = new int[]{1, 2, 0, 0, 0, 3, 6};

        moveZerosToEnd.move(testArray);

        Assert.assertArrayEquals(new int[]{1, 2, 3, 6, 0, 0, 0}, testArray);
    }
}