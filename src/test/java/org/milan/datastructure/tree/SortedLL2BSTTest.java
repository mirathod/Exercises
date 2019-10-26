package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.milan.datastructure.linkedlist.LinkedList;

/**
 * Test Class for {@link SortedLL2BST}
 *
 * @author Milan Rathod
 */
public class SortedLL2BSTTest {

    private LinkedList<Integer> linkedList;

    @Before
    public void setup() {
        linkedList = new LinkedList<>(new LinkedList.Node<>(1));

        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(5);
        linkedList.insertAtEnd(6);
        linkedList.insertAtEnd(7);
    }

    @Test
    public void testConvert() {
        SortedLL2BST sortedLL2BST = new SortedLL2BST();

        BinarySearchTree.Node root = sortedLL2BST.convert(linkedList.getHead(), 7);

        Assert.assertEquals(4, root.key);
    }
}