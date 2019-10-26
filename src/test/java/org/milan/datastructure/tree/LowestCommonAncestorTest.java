package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link LowestCommonAncestor}
 *
 * @author Milan Rathod
 */
public class LowestCommonAncestorTest {

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
    public void testFindLCA() {
        Assert.assertEquals(2, new LowestCommonAncestor().findLCA(binaryTree.getRoot(), 4, 5).key);
    }
}