package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link NthNodeFromEnd}
 *
 * @author Milan Rathod
 */
public class NthNodeFromEndTest {

    private LinkedList<Integer> linkedList;

    private NthNodeFromEnd nthNodeFromEnd;

    @Before
    public void setup() {
        linkedList = new LinkedList<>(new LinkedList.Node<>(1));

        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(5);
        linkedList.insertAtEnd(6);

        nthNodeFromEnd = new NthNodeFromEnd();
    }

    @Test
    public void testFind() {
        LinkedList.Node<Integer> result = nthNodeFromEnd.find(linkedList.getHead(), 3);

        Assert.assertEquals(4, result.data.intValue());

        result = nthNodeFromEnd.find(linkedList.getHead(), 6);

        Assert.assertEquals(1, result.data.intValue());
    }

    @Test
    public void testFindV2() {
        LinkedList.Node<Integer> result = nthNodeFromEnd.findV2(linkedList.getHead(), 3);

        Assert.assertEquals(4, result.data.intValue());

        result = nthNodeFromEnd.find(linkedList.getHead(), 6);

        Assert.assertEquals(1, result.data.intValue());
    }
}