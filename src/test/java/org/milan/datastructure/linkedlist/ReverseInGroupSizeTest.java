package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link ReverseInGroupSize}
 *
 * @author Milan Rathod
 */
public class ReverseInGroupSizeTest {

    private LinkedList<Integer> linkedList;

    @Before
    public void setup() {
        linkedList = new LinkedList<>(new LinkedList.Node<>(5));

        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(15);
        linkedList.insertAtEnd(20);
    }

    @Test
    public void reverseByGroupSize() {
        ReverseInGroupSize reverseInGroupSize = new ReverseInGroupSize();

        LinkedList.Node<Integer> reversedHead = reverseInGroupSize.reverseByGroupSize(linkedList.getHead(), 3);

        LinkedList<Integer> reversedLinkedList = new LinkedList<>(reversedHead);

        Assert.assertEquals(4, reversedLinkedList.getSize());

        Assert.assertEquals(15, reversedLinkedList.searchByIndex(0).getData().intValue());

        Assert.assertEquals(10, reversedLinkedList.searchByIndex(1).getData().intValue());

        Assert.assertEquals(5, reversedLinkedList.searchByIndex(2).getData().intValue());

        Assert.assertEquals(20, reversedLinkedList.searchByIndex(3).getData().intValue());
    }
}