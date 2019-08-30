package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link AddNumber}
 *
 * @author Milan Rathod
 */
public class AddNumberTest {

    private AddNumber addNumber;

    @Before
    public void setup() {
        addNumber = new AddNumber();
    }

    @Test
    public void testAdd() {
        LinkedList<Integer> linkedList = new LinkedList<>(new LinkedList.Node<>(1));

        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(5);
        addNumber.add(linkedList.getHead(), 5);

        Assert.assertEquals(5, linkedList.searchByIndex(3).data.intValue());
        Assert.assertEquals(0, linkedList.searchByIndex(4).data.intValue());
    }

    @Test
    public void testAdd_newNodeAddition() {
        LinkedList<Integer> linkedList = new LinkedList<>(new LinkedList.Node<>(9));

        linkedList.insertAtEnd(9);

        LinkedList.Node<Integer> head = addNumber.add(linkedList.getHead(), 5);

        Assert.assertEquals(3, linkedList.size(head));

        Assert.assertEquals(1, head.getData().intValue());
        Assert.assertEquals(0, head.getNext().getData().intValue());
        Assert.assertEquals(4, head.getNext().getNext().getData().intValue());
    }
}