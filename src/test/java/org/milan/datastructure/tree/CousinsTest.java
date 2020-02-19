package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link Cousins}
 *
 * @author Milan Rathod
 */
public class CousinsTest {

    private BinaryTree binaryTree;

    private Cousins cousins;

    @Before
    public void setUp() {
        binaryTree = new BinaryTree(4);
        binaryTree.getRoot().left = new BinaryTree.Node(7);
        binaryTree.getRoot().right = new BinaryTree.Node(5);
        binaryTree.getRoot().left.left = new BinaryTree.Node(1);
        binaryTree.getRoot().left.right = new BinaryTree.Node(8);
        binaryTree.getRoot().right.left = new BinaryTree.Node(11);
        binaryTree.getRoot().right.right = new BinaryTree.Node(6);

        cousins = new Cousins();
    }

    @Test
    public void testIsCousins() {
        Assert.assertTrue(cousins.isCousins(binaryTree.getRoot(), new BinaryTree.Node(1), new BinaryTree.Node(11)));

        Assert.assertFalse(cousins.isCousins(binaryTree.getRoot(), new BinaryTree.Node(1), new BinaryTree.Node(8)));
    }

    @Test
    public void testIsCousinsV2() {
        Assert.assertTrue(cousins.isCousinsV2(binaryTree.getRoot(), new BinaryTree.Node(1), new BinaryTree.Node(11)));

        Assert.assertFalse(cousins.isCousinsV2(binaryTree.getRoot(), new BinaryTree.Node(1), new BinaryTree.Node(8)));
    }
}