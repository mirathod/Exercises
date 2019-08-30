package org.milan.datastructure.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test Class for {@link LinkedList}
 *
 * @author Milan Rathod
 */
public class LinkedListTest {

    private LinkedList<Integer> linkedList;

    @Before
    public void setup() {
        linkedList = new LinkedList<>(new LinkedList.Node<>(5));

        linkedList.insertAfterSpecifiedPosition(10, 0);
        linkedList.insertAfterSpecifiedPosition(15, 1);
    }

    @Test
    public void testInsertBeforeHead() {
        assertEquals(3, linkedList.getSize());

        linkedList.insertBeforeHead(1);

        assertTrue(linkedList.contains(1));

        assertEquals(1, linkedList.searchByIndex(0).data.intValue());

        assertEquals(4, linkedList.getSize());
    }

    @Test
    public void testInsertAfterSpecifiedNode() {
        assertEquals(3, linkedList.getSize());

        linkedList.insertAfterSpecifiedNode(10, 12);

        assertTrue(linkedList.contains(12));

        assertEquals(12, linkedList.searchByIndex(2).data.intValue());

        assertEquals(4, linkedList.getSize());
    }

    @Test
    public void testInsertAfterSpecifiedPosition() {
        assertEquals(3, linkedList.getSize());

        linkedList.insertAfterSpecifiedPosition(12, 1);

        assertTrue(linkedList.contains(12));

        assertEquals(12, linkedList.searchByIndex(2).data.intValue());

        assertEquals(4, linkedList.getSize());
    }

    @Test
    public void testInsertAtEnd() {
        assertEquals(3, linkedList.getSize());

        linkedList.insertAtEnd(20);

        assertTrue(linkedList.contains(20));

        assertEquals(20, linkedList.searchByIndex(3).data.intValue());

        assertEquals(4, linkedList.getSize());
    }

    @Test
    public void testDeleteNodeByKey() {
        assertEquals(3, linkedList.getSize());

        linkedList.deleteNodeByKey(15);

        assertEquals(2, linkedList.getSize());

        assertFalse(linkedList.contains(15));
    }

    @Test
    public void testDeleteNodeByPosition() {
        assertEquals(3, linkedList.getSize());

        linkedList.deleteNodeByPosition(1);

        assertEquals(2, linkedList.getSize());

        assertFalse(linkedList.contains(10));
    }
}