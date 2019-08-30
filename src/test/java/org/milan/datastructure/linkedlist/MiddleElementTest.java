package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link MiddleElement}
 *
 * @author Milan Rathod
 */
public class MiddleElementTest {

    private LinkedList<Integer> linkedList;

    @Test
    public void testOddLengthLinkedList() {
        linkedList = new LinkedList<>(new LinkedList.Node<>(1));

        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(5);

        MiddleElement middleElement = new MiddleElement();

        LinkedList.Node<Integer> result = middleElement.find(linkedList.getHead());

        Assert.assertEquals(3, result.data.intValue());

        result = middleElement.findV2(linkedList.getHead());

        Assert.assertEquals(3, result.data.intValue());
    }

    @Test
    public void testEvenLengthLinkedList() {
        linkedList = new LinkedList<>(new LinkedList.Node<>(1));

        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(5);
        linkedList.insertAtEnd(6);

        MiddleElement middleElement = new MiddleElement();

        LinkedList.Node<Integer> result = middleElement.find(linkedList.getHead());

        Assert.assertEquals(4, result.data.intValue());

        result = middleElement.findV2(linkedList.getHead());

        Assert.assertEquals(4, result.data.intValue());
    }
}