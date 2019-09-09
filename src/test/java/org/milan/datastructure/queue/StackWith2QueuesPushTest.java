package org.milan.datastructure.queue;

import org.junit.Assert;
import org.junit.Test;
import org.milan.datastructure.queue.StackWith2QueuesPush;

/**
 * Test Class for {@link StackWith2QueuesPush}
 *
 * @author Milan Rathod
 */
public class StackWith2QueuesPushTest {

    @Test
    public void testStackOperations() {
        StackWith2QueuesPush stackWith2QueuesPush = new StackWith2QueuesPush();

        Assert.assertEquals(0, stackWith2QueuesPush.size());

        stackWith2QueuesPush.push(1);
        stackWith2QueuesPush.push(2);
        stackWith2QueuesPush.push(3);

        Assert.assertEquals(3, stackWith2QueuesPush.pop());

        Assert.assertEquals(2, stackWith2QueuesPush.size());
    }
}