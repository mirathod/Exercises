package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link RemoveDuplicates}
 *
 * @author Milan Rathod
 */
public class RemoveDuplicatesTest {

    @Test
    public void removeDuplicatesSorted() {
        LinkedList<Integer> linkedList = new LinkedList<>(new LinkedList.Node<>(1));
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();

        LinkedList.Node<Integer> newHead = removeDuplicates.removeDuplicatesSorted(linkedList.getHead());

        linkedList = new LinkedList<>(newHead);

        Assert.assertEquals(4, linkedList.getSize());
    }

    @Test
    public void removeDuplicatesUnsorted() {
        LinkedList<Integer> linkedList = new LinkedList<>(new LinkedList.Node<>(1));
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(2);

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();

        LinkedList.Node<Integer> newHead = removeDuplicates.removeDuplicatesUnsorted(linkedList.getHead());

        linkedList = new LinkedList<>(newHead);

        Assert.assertEquals(4, linkedList.getSize());
    }
}