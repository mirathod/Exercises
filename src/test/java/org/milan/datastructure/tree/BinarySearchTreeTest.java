package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link BinarySearchTree}
 *
 * @author Milan Rathod
 */
public class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @Before
    public void setup() {
        binarySearchTree = new BinarySearchTree(20);

        binarySearchTree.insert(10);
        binarySearchTree.insert(15);
        binarySearchTree.insert(5);
        binarySearchTree.insert(30);
        binarySearchTree.insert(35);
        binarySearchTree.insert(25);
    }

    @Test
    public void testPreOrder() {
        String result = binarySearchTree.preOrder(binarySearchTree.getRoot());

        Assert.assertEquals("2010515302535", result);
    }

    @Test
    public void testPreOrderIterative() {
        String result = binarySearchTree.preOrderIterative(binarySearchTree.getRoot());

        Assert.assertEquals("2010515302535", result);
    }

    @Test
    public void testInOrder() {
        String result = binarySearchTree.inOrder(binarySearchTree.getRoot());

        Assert.assertEquals("5101520253035", result);
    }

    @Test
    public void testInOrderIterative() {
        String result = binarySearchTree.inOrderIterative(binarySearchTree.getRoot());

        Assert.assertEquals("5101520253035", result);
    }

    @Test
    public void testPostOrder() {
        String result = binarySearchTree.postOrder(binarySearchTree.getRoot());

        Assert.assertEquals("5151025353020", result);
    }

    @Test
    public void testPostOrderIterative() {
        String result = binarySearchTree.postOrderIterative(binarySearchTree.getRoot());

        Assert.assertEquals("5151025353020", result);
    }

    @Test
    public void testLevelOrder() {
        String result = binarySearchTree.levelOrder(binarySearchTree.getRoot());

        Assert.assertEquals("2010305152535", result);
    }

    @Test
    public void testLevelOrderReverse() {
        String result = binarySearchTree.levelOrderReverse(binarySearchTree.getRoot());

        Assert.assertEquals("5152535103020", result);
    }

    @Test
    public void testSize() {
        Assert.assertEquals(7, binarySearchTree.size(binarySearchTree.getRoot()));
    }

    @Test
    public void testSizeIterative() {
        Assert.assertEquals(7, binarySearchTree.sizeIterative(binarySearchTree.getRoot()));
    }

    @Test
    public void testHeight() {
        Assert.assertEquals(3, binarySearchTree.height(binarySearchTree.getRoot()));
    }

    @Test
    public void testHeightIterative() {
        Assert.assertEquals(3, binarySearchTree.heightIterative(binarySearchTree.getRoot()));
    }

    @Test
    public void testMinimumDepth() {
        Assert.assertEquals(3, binarySearchTree.minimumDepth(binarySearchTree.getRoot()));
    }

    @Test
    public void testFindDeepestNode() {
        Assert.assertEquals(35, binarySearchTree.findDeepestNode(binarySearchTree.getRoot()).key);
    }

    @Test
    public void testGetTotalLeafNodes() {
        Assert.assertEquals(4, binarySearchTree.getTotalLeafNodes(binarySearchTree.getRoot()));
    }

    @Test
    public void testGetTotalLeafNodesIterative() {
        Assert.assertEquals(4, binarySearchTree.getTotalLeafNodesIterative(binarySearchTree.getRoot()));
    }

    @Test
    public void testMaximumWidth() {
        Assert.assertEquals(4, binarySearchTree.maximumWidth(binarySearchTree.getRoot()));
    }

    @Test
    public void testFindMaximumLevelSum() {
        Assert.assertEquals(80, binarySearchTree.findMaximumLevelSum(binarySearchTree.getRoot()));
    }

    @Test
    public void testLca() {
        Assert.assertEquals(20, binarySearchTree.lca(binarySearchTree.getRoot(), 5, 35).key);
        Assert.assertEquals(30, binarySearchTree.lca(binarySearchTree.getRoot(), 25, 35).key);
    }

    @Test
    public void testIsBST() {
        Assert.assertTrue(binarySearchTree.isBST(binarySearchTree.getRoot()));
    }
}