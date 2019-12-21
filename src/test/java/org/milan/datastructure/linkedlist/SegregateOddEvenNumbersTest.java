package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link SegregateOddEvenNumbers}
 *
 * @author Milan Rathod
 */
public class SegregateOddEvenNumbersTest {

    private LinkedList<Integer> linkedList;

    @Before
    public void setup() {
        linkedList = new LinkedList<>(new LinkedList.Node<>(11));

        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(9);
        linkedList.insertAtEnd(6);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(1);
        linkedList.insertAtEnd(0);
    }

    @Test
    public void testSegregate() {
        SegregateOddEvenNumbers segregateOddEvenNumbers = new SegregateOddEvenNumbers();

        LinkedList.Node<Integer> segregatedHead = segregateOddEvenNumbers.segregate(linkedList.getHead());

        LinkedList<Integer> newList = new LinkedList<>(segregatedHead);

        Assert.assertEquals(7, newList.getSize());

        Assert.assertEquals(6,newList.searchByIndex(1).getData().intValue());

        Assert.assertEquals(11,newList.searchByIndex(4).getData().intValue());
    }
}