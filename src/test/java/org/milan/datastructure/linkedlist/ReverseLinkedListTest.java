package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link ReverseLinkedList}
 *
 * @author Milan Rathod
 */
public class ReverseLinkedListTest {

    private ReverseLinkedList reverseLinkedList;

    private LinkedList<Integer> linkedList;

    @Before
    public void setUp() {
        linkedList = new LinkedList<>(new LinkedList.Node<>(1));

        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(5);
        linkedList.insertAtEnd(6);

        reverseLinkedList = new ReverseLinkedList();
    }

    @Test
    public void testReverseByIterative() {
        LinkedList.Node<Integer> newHead = reverseLinkedList.reverseByIterative(linkedList.getHead());

        Assert.assertNotNull(newHead);

        Assert.assertEquals(6, newHead.getData().intValue());

        Assert.assertEquals(6, linkedList.size(newHead));
    }

    @Test
    public void testReverseByRecursive() {
        LinkedList.Node<Integer> newHead = reverseLinkedList.reverseByRecursive(linkedList.getHead());

        Assert.assertNotNull(newHead);

        Assert.assertEquals(6, newHead.getData().intValue());

        Assert.assertEquals(6, linkedList.size(newHead));
    }
}