package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Test Class for {@link SplitCircularList}
 *
 * @author Milan Rathod
 */
public class SplitCircularListTest {

    private CircularLinkedList<Integer> circularLinkedList;

    @Before
    public void setup() {
        circularLinkedList = new CircularLinkedList<>(new CircularLinkedList.Node<>(5));

        circularLinkedList.insertAtEnd(10);
        circularLinkedList.insertAtEnd(15);
        circularLinkedList.insertAtEnd(20);
        circularLinkedList.insertAtEnd(25);
    }

    @Test
    public void testSplit() {
        SplitCircularList splitCircularList = new SplitCircularList();

        List<CircularLinkedList.Node<Integer>> splitHeads = splitCircularList.split(circularLinkedList.getHead());

        Assert.assertEquals(5, splitHeads.get(0).getData().intValue());

        Assert.assertEquals(20, splitHeads.get(1).getData().intValue());
    }
}