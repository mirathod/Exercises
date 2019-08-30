package org.milan.datastructure.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test Class for {@link CircularLinkedList}
 *
 * @author Milan Rathod
 */
public class CircularLinkedListTest {

    private CircularLinkedList<Integer> circularLinkedList;

    @Before
    public void setup() {
        circularLinkedList = new CircularLinkedList<>(new CircularLinkedList.Node<>(5));
    }

    @Test
    public void testInsertAfterSpecifiedPosition() {
        assertEquals(1, circularLinkedList.getSize());

        circularLinkedList.insertAfterSpecifiedPosition(10, 0);

        assertTrue(circularLinkedList.contains(10));

        assertEquals(2, circularLinkedList.getSize());
    }

    @Test
    public void testInsertBeforeHead() {
        assertEquals(1, circularLinkedList.getSize());

        circularLinkedList.insertBeforeHead(10);

        assertTrue(circularLinkedList.contains(10));

        assertEquals(2, circularLinkedList.getSize());
    }

    @Test
    public void testInsertAtEnd() {
        assertEquals(1, circularLinkedList.getSize());

        circularLinkedList.insertAtEnd(10);

        assertTrue(circularLinkedList.contains(10));

        assertEquals(2, circularLinkedList.getSize());
    }

    @Test
    public void testDeleteNodeByPosition() {
        circularLinkedList.insertAtEnd(10);

        assertEquals(2, circularLinkedList.getSize());

        circularLinkedList.deleteNodeByPosition(0);

        assertFalse(circularLinkedList.contains(5));

        assertEquals(1, circularLinkedList.getSize());
    }

    @Test
    public void testDeleteNodeByKey() {
        circularLinkedList.insertAtEnd(10);

        assertEquals(2, circularLinkedList.getSize());

        circularLinkedList.deleteNodeByKey(10);

        assertFalse(circularLinkedList.contains(10));

        assertEquals(1, circularLinkedList.getSize());
    }
}