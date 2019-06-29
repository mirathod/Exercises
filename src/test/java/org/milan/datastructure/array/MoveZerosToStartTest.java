package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link MoveZerosToStart}
 *
 * @author Milan Rathod
 */
public class MoveZerosToStartTest {

    @Test
    public void move() {
        int[] testArray = new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};

        MoveZerosToStart moveZerosToStart = new MoveZerosToStart();

        moveZerosToStart.move(testArray);

        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 1, 9, 8, 4, 2, 7, 6}, testArray);

        testArray = new int[]{1, 2, 0, 4, 3, 0, 5, 0};

        moveZerosToStart.move(testArray);

        Assert.assertArrayEquals(new int[]{0, 0, 0, 1, 2, 4, 3, 5}, testArray);

        testArray = new int[]{1, 2, 0, 0, 0, 3, 6};

        moveZerosToStart.move(testArray);

        Assert.assertArrayEquals(new int[]{0, 0, 0, 1, 2, 3, 6}, testArray);

    }
}