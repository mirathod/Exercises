package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link SwapNodes}
 *
 * @author Milan Rathod
 */
public class SwapNodesTest {

    @Test
    public void testSwap() {
        LinkedList<Integer> linkedList = new LinkedList<>(new LinkedList.Node<>(1));
        linkedList.insertAtEnd(7);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(5);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(6);

        SwapNodes swapNodes = new SwapNodes();

        LinkedList.Node<Integer> newHead = swapNodes.swap(linkedList.getHead(), 2, 4);

        linkedList = new LinkedList<>(newHead);

        Assert.assertEquals(4, linkedList.searchByIndex(2).getData().intValue());

        Assert.assertEquals(2, linkedList.searchByIndex(4).getData().intValue());
    }
}