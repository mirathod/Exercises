package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link PartitionList}
 *
 * @author Milan Rathod
 */
public class PartitionListTest {

    @Test
    public void partition() {
        LinkedList<Integer> linkedList = new LinkedList<>(new LinkedList.Node<>(1));
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(5);
        linkedList.insertAtEnd(2);

        PartitionList partitionList = new PartitionList();

        LinkedList.Node<Integer> partitionHead = partitionList.partition(linkedList.getHead(), 3);

        linkedList = new LinkedList<>(partitionHead);

        Assert.assertEquals(6, linkedList.getSize());

        Assert.assertEquals(2, linkedList.searchByIndex(1).getData().intValue());

        Assert.assertEquals(4, linkedList.searchByIndex(3).getData().intValue());

        Assert.assertEquals(5, linkedList.searchByIndex(5).getData().intValue());
    }
}