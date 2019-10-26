package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link ZigZagTraversal}
 *
 * @author Milan Rathod
 */
public class ZigZagTraversalTest {

    private BinaryTree binaryTree;

    @Before
    public void setup() {
        binaryTree = new BinaryTree(1);
        binaryTree.getRoot().left = new BinaryTree.Node(2);
        binaryTree.getRoot().right = new BinaryTree.Node(3);
        binaryTree.getRoot().left.left = new BinaryTree.Node(4);
        binaryTree.getRoot().left.right = new BinaryTree.Node(5);
        binaryTree.getRoot().right.left = new BinaryTree.Node(6);
        binaryTree.getRoot().right.right = new BinaryTree.Node(7);
    }

    @Test
    public void testTraverse() {
        Assert.assertEquals("1 3 2 4 5 6 7", new ZigZagTraversal().traverse(binaryTree.getRoot()));
    }
}