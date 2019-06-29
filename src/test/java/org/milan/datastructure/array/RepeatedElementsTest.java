package org.milan.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Test Class for {@link RepeatedElements}
 *
 * @author Milan Rathod
 */
public class RepeatedElementsTest {

    @Test
    public void getTwoRepeatedElements() {
        RepeatedElements repeatedElements = new RepeatedElements();

        List<Integer> result = repeatedElements.getTwoRepeatedElements(new int[]{4, 2, 4, 5, 2, 3, 1}, 7);

        Assert.assertEquals(4, (int) result.get(0));

        Assert.assertEquals(2, (int) result.get(1));
    }

    @Test
    public void getTwoRepeatedElementsByExpression() {
        RepeatedElements repeatedElements = new RepeatedElements();

        List<Integer> result = repeatedElements.getTwoRepeatedElementsByExpression(new int[]{4, 2, 4, 5, 2, 3, 1}, 7);

        Assert.assertEquals(4, (int) result.get(0));

        Assert.assertEquals(2, (int) result.get(1));
    }
}