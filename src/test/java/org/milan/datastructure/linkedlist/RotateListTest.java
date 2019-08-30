package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link RotateList}
 *
 * @author Milan Rathod
 */
public class RotateListTest {

    @Test
    public void testRotate() {
        LinkedList<Integer> linkedList = new LinkedList<>(new LinkedList.Node<>(1));
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(5);

        RotateList rotateList = new RotateList();

        LinkedList.Node<Integer> newHead = rotateList.rotate(linkedList.getHead(), 2);

        linkedList = new LinkedList<>(newHead);

        Assert.assertEquals(5, linkedList.getSize());

        Assert.assertEquals(4, linkedList.searchByIndex(0).getData().intValue());

        Assert.assertEquals(5, linkedList.searchByIndex(1).getData().intValue());

        Assert.assertEquals(1, linkedList.searchByIndex(2).getData().intValue());
    }
}