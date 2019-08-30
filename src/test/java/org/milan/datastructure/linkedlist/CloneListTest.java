package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test Class for {@link CloneList}
 *
 * @author Milan Rathod
 */
public class CloneListTest {

    private DoublyLinkedList<Integer> doublyLinkedList;

    private CloneList cloneList;

    @Before
    public void setup() {
        doublyLinkedList = new DoublyLinkedList<>(new DoublyLinkedList.Node<>(5));

        doublyLinkedList.insertAtEnd(10);
        doublyLinkedList.insertAtEnd(15);
        doublyLinkedList.insertAtEnd(20);

        doublyLinkedList.getHead().next.prev = doublyLinkedList.getHead().next.next.next;

        cloneList = new CloneList();
    }

    @Test
    public void testClone() {
        DoublyLinkedList<Integer> clonedList = cloneList.clone(doublyLinkedList.getHead());

        Assert.assertEquals(4, clonedList.getSize());
    }

    @Test
    public void testCloneV2() {
        DoublyLinkedList<Integer> clonedList = cloneList.cloneV2(doublyLinkedList.getHead());

        Assert.assertEquals(4, clonedList.getSize());
    }
}