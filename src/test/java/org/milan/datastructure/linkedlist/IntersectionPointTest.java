package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link IntersectionPoint}
 *
 * @author Milan Rathod
 */
public class IntersectionPointTest {

    private LinkedList<Integer> firstLinkedList;

    private LinkedList<Integer> secondLinkedList;

    private IntersectionPoint intersectionPoint;

    @Before
    public void setup() {
        firstLinkedList = new LinkedList<>(new LinkedList.Node<>(5));

        firstLinkedList.insertAtEnd(10);
        firstLinkedList.insertAtEnd(15);
        firstLinkedList.insertAtEnd(20);
        firstLinkedList.insertAtEnd(25);

        secondLinkedList = new LinkedList<>(new LinkedList.Node<>(3));

        secondLinkedList.insertAtEnd(7);
        secondLinkedList.insertAtEnd(20);
        secondLinkedList.insertAtEnd(25);

        intersectionPoint = new IntersectionPoint();
    }

    @Test
    public void testFind() {
        LinkedList.Node<Integer> intersectedNode = intersectionPoint.find(firstLinkedList.getHead(), secondLinkedList.getHead());

        Assert.assertEquals(20, intersectedNode.getData().intValue());
    }
}