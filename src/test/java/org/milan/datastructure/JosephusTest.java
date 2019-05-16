package org.milan.datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link Josephus}
 *
 * @author Milan Rathod
 */
public class JosephusTest {

    @Test
    public void testLuckyPerson() {
        Josephus josephus = new Josephus();

        Assert.assertEquals(4, josephus.luckyPerson(7, 3));
    }
}