package org.milan.datastructure.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test Class for {@link DoublyLinkedList}
 *
 * @author Milan Rathod
 */
public class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> doublyLinkedList;

    @Before
    public void setup() {
        doublyLinkedList = new DoublyLinkedList<>(new DoublyLinkedList.Node<>(5));
    }

    @Test
    public void testInsertBeforeHead() {
        assertEquals(1, doublyLinkedList.getSize());

        doublyLinkedList.insertBeforeHead(10);

        assertTrue(doublyLinkedList.contains(10));

        assertEquals(2, doublyLinkedList.getSize());
    }

    @Test
    public void testInsertAfterSpecifiedNode() {
        assertEquals(1, doublyLinkedList.getSize());

        doublyLinkedList.insertAfterSpecifiedNode(5, 10);

        assertTrue(doublyLinkedList.contains(10));

        assertEquals(2, doublyLinkedList.getSize());
    }

    @Test
    public void testInsertAfterSpecifiedPosition() {
        assertEquals(1, doublyLinkedList.getSize());

        doublyLinkedList.insertAfterSpecifiedPosition(10, 0);

        assertTrue(doublyLinkedList.contains(10));

        assertEquals(2, doublyLinkedList.getSize());
    }

    @Test
    public void testInsertAtEnd() {
        assertEquals(1, doublyLinkedList.getSize());

        doublyLinkedList.insertAtEnd(10);

        assertTrue(doublyLinkedList.contains(10));

        assertEquals(2, doublyLinkedList.getSize());
    }

    @Test
    public void testDeleteNodeByKey() {
        doublyLinkedList.insertAtEnd(10);

        assertEquals(2, doublyLinkedList.getSize());

        doublyLinkedList.deleteNodeByKey(10);

        assertFalse(doublyLinkedList.contains(10));

        assertEquals(1, doublyLinkedList.getSize());
    }

    @Test
    public void testDeleteNodeByPosition() {
        doublyLinkedList.insertAtEnd(10);

        assertEquals(2, doublyLinkedList.getSize());

        doublyLinkedList.deleteNodeByPosition(1);

        assertFalse(doublyLinkedList.contains(10));

        assertEquals(1, doublyLinkedList.getSize());
    }
}