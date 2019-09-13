package org.milan.datastructure.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link StackWith2QueuesPop}
 *
 * @author Milan Rathod
 */
public class StackWith2QueuesPopTest {

    @Test
    public void testStackOperations() {
        StackWith2QueuesPop stackWith2QueuesPop = new StackWith2QueuesPop();

        Assert.assertEquals(0, stackWith2QueuesPop.size());

        stackWith2QueuesPop.push(1);
        stackWith2QueuesPop.push(2);
        stackWith2QueuesPop.push(3);

        Assert.assertEquals(3, stackWith2QueuesPop.pop());

        Assert.assertEquals(2, stackWith2QueuesPop.size());
    }
}