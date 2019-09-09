package org.milan.datastructure.misc;

import org.junit.Assert;
import org.junit.Test;
import org.milan.datastructure.misc.Josephus;

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