package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link SumTree}
 *
 * @author Milan Rathod
 */
public class SumTreeTest {

    private BinaryTree binaryTree;

    private SumTree sumTree;

    @Before
    public void setup() {
        sumTree = new SumTree();
        binaryTree = new BinaryTree(26);
        binaryTree.getRoot().left = new BinaryTree.Node(3);
        binaryTree.getRoot().right = new BinaryTree.Node(10);
        binaryTree.getRoot().left.right = new BinaryTree.Node(3);
        binaryTree.getRoot().right.left = new BinaryTree.Node(6);
        binaryTree.getRoot().right.right = new BinaryTree.Node(4);
    }

    @Test
    public void testIsSumTree() {
        Assert.assertTrue(sumTree.isSumTree(binaryTree.getRoot()));
    }

    @Test
    public void testIsSumTreeV2() {
        Assert.assertTrue(sumTree.isSumTreeV2(binaryTree.getRoot()));
    }
}