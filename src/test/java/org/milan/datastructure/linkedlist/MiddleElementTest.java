package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link MiddleElement}
 *
 * @author Milan Rathod
 */
public class MiddleElementTest {

    private LinkedList linkedList;

    @Test
    public void testOddLengthLinkedList() {
        linkedList = new LinkedList();

        linkedList.head = new LinkedList.Node(1);

        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(5);

        MiddleElement middleElement = new MiddleElement();

        LinkedList.Node result = middleElement.find(linkedList.head);

        Assert.assertEquals(3, result.data);

        result = middleElement.findV2(linkedList.head);

        Assert.assertEquals(3, result.data);
    }

    @Test
    public void testEvenLengthLinkedList() {
        linkedList = new LinkedList();

        linkedList.head = new LinkedList.Node(1);

        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(5);
        linkedList.insertAtEnd(6);

        MiddleElement middleElement = new MiddleElement();

        LinkedList.Node result = middleElement.find(linkedList.head);

        Assert.assertEquals(4, result.data);

        result = middleElement.findV2(linkedList.head);

        Assert.assertEquals(4, result.data);
    }
}