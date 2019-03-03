package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class {@link LinkedList}
 *
 * @author Milan Rathod
 */
public class LinkedListTest {

    private LinkedList linkedList;

    @Before
    public void setup() {
        linkedList = new LinkedList();

        linkedList.head = new LinkedList.Node(5);
        LinkedList.Node second = new LinkedList.Node(10);
        LinkedList.Node third = new LinkedList.Node(15);

        linkedList.head.next = second;
        second.next = third;

    }

    @Test
    public void testInsert() {

        linkedList.insertBeforeHead(1);

        linkedList.insertAfterSpecifiedNode(linkedList.get(2), 12);

        linkedList.insertAtEnd(20);

        Assert.assertEquals(1, linkedList.get(0).data);

        Assert.assertEquals(12, linkedList.get(3).data);

        Assert.assertEquals(20, linkedList.get(5).data);

    }

    @Test
    public void testDelete() {
        linkedList.deleteNodeByKey(15);

        Assert.assertEquals(5, linkedList.get(0).data);

        Assert.assertEquals(10, linkedList.get(1).data);

        linkedList.deleteNodeByPosition(2);

        Assert.assertEquals(5, linkedList.get(0).data);

    }

    @Test
    public void testLoop() {

        Assert.assertEquals(0, linkedList.detectAndCountLoop());

        linkedList.insertAtEnd(20);

        LinkedList.Node node = linkedList.get(3);

        node.next = linkedList.get(1);

        Assert.assertEquals(3, linkedList.detectAndCountLoop());

    }

    @Test
    public void testRemoveDuplicatesSorted() {

        linkedList.insertBeforeHead(5);

        linkedList.insertAfterSpecifiedNode(linkedList.get(2), 10);

        linkedList.insertAtEnd(15);

        linkedList.removeDuplicatesSorted();

        Assert.assertEquals(5, linkedList.get(0).data);

        Assert.assertEquals(10, linkedList.get(1).data);

        Assert.assertEquals(15, linkedList.get(2).data);
    }

    @Test
    public void testRemoveDuplicatesUnsorted() {

        linkedList.insertBeforeHead(15);

        linkedList.insertBeforeHead(10);

        linkedList.insertAtEnd(5);

        linkedList.removeDuplicatesUnsorted();

        Assert.assertEquals(10, linkedList.get(0).data);

        Assert.assertEquals(15, linkedList.get(1).data);

        Assert.assertEquals(5, linkedList.get(2).data);

    }

    @Test
    public void testSwap() {
        linkedList.insertBeforeHead(7);

        linkedList.insertBeforeHead(2);

        linkedList.swap(2, 15);

        Assert.assertEquals(15, linkedList.get(0).data);

        Assert.assertEquals(2, linkedList.get(4).data);
    }

    @Test
    public void testSwapPairs() {
        linkedList.swapPairs(linkedList.head);

        Assert.assertEquals(10, linkedList.get(0).data);

        Assert.assertEquals(5, linkedList.get(1).data);
    }
}