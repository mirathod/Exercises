package org.milan.datastructure.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test Class for {@link DetectLoop}
 *
 * @author Milan Rathod
 */
public class DetectLoopTest {

    private LinkedList<Integer> linkedList;

    private DetectLoop detectLoop;

    @Before
    public void setup() {
        linkedList = new LinkedList<>(new LinkedList.Node<>(5));

        linkedList.insertAfterSpecifiedPosition(10, 0);
        linkedList.insertAfterSpecifiedPosition(15, 1);

        detectLoop = new DetectLoop();
    }

    @Test
    public void testDetectLoop_LoopExists() {
        assertNull(null, detectLoop.detect(linkedList.getHead()));
    }

    @Test
    public void testDetectLoop_LoopNotExists() {
        linkedList.insertAtEnd(20);

        LinkedList.Node<Integer> node = linkedList.searchByIndex(2);

        node.next = linkedList.searchByIndex(0);

        assertEquals(5, detectLoop.detect(linkedList.getHead()).getData().intValue());
    }
}