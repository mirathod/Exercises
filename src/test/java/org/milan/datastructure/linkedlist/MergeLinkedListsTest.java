package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link MergeLinkedLists}
 *
 * @author Milan Rathod
 */
public class MergeLinkedListsTest {

    private LinkedList<Integer> firstLinkedList;

    private LinkedList<Integer> secondLinkedList;

    private MergeLinkedLists mergeLinkedLists;

    @Before
    public void setup() {
        firstLinkedList = new LinkedList<>(new LinkedList.Node<>(5));

        firstLinkedList.insertAtEnd(10);
        firstLinkedList.insertAtEnd(15);
        firstLinkedList.insertAtEnd(20);
        firstLinkedList.insertAtEnd(25);

        secondLinkedList = new LinkedList<>(new LinkedList.Node<>(3));

        secondLinkedList.insertAtEnd(7);
        secondLinkedList.insertAtEnd(30);

        mergeLinkedLists = new MergeLinkedLists();
    }

    @Test
    public void testMergeByIterative() {
        LinkedList.Node<Integer> mergedHead = mergeLinkedLists.mergeByIterative(firstLinkedList.getHead(), secondLinkedList.getHead());

        LinkedList<Integer> mergedLinkedList = new LinkedList<>(mergedHead);

        Assert.assertEquals(8, mergedLinkedList.getSize());

        Assert.assertEquals(3, mergedLinkedList.searchByIndex(0).getData().intValue());

        Assert.assertEquals(10, mergedLinkedList.searchByIndex(3).getData().intValue());

        Assert.assertEquals(30, mergedLinkedList.searchByIndex(7).getData().intValue());
    }

    @Test
    public void testMergeByRecursive() {
        LinkedList.Node<Integer> mergedHead = mergeLinkedLists.mergeByRecursive(firstLinkedList.getHead(), secondLinkedList.getHead());

        LinkedList<Integer> mergedLinkedList = new LinkedList<>(mergedHead);

        Assert.assertEquals(8, mergedLinkedList.getSize());

        Assert.assertEquals(3, mergedLinkedList.searchByIndex(0).getData().intValue());

        Assert.assertEquals(10, mergedLinkedList.searchByIndex(3).getData().intValue());

        Assert.assertEquals(30, mergedLinkedList.searchByIndex(7).getData().intValue());


    }
}