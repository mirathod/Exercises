package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link NthNodeFromEnd}
 *
 * @author Milan Rathod
 */
public class NthNodeFromEndTest {

    private LinkedList linkedList;

    @Test
    public void find() {
        linkedList = new LinkedList();

        linkedList.head = new LinkedList.Node(1);

        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(5);
        linkedList.insertAtEnd(6);

        NthNodeFromEnd nthNodeFromEnd = new NthNodeFromEnd();

        LinkedList.Node result = nthNodeFromEnd.find(linkedList.head, 3);

        Assert.assertEquals(4, result.data);

        result = nthNodeFromEnd.find(linkedList.head, 6);

        Assert.assertEquals(1, result.data);
    }
}