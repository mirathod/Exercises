package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link SpecialPreOrderTraversal}
 *
 * @author Milan Rathod
 */
public class SpecialPreOrderTraversalTest {

    @Test
    public void constructTree() {
        int[] pre = new int[]{10, 30, 20, 5, 15};
        char[] preLN = new char[]{'N', 'N', 'L', 'L', 'L'};

        BinaryTree binaryTree = new BinaryTree();
        SpecialPreOrderTraversal specialPreOrderTraversal = new SpecialPreOrderTraversal();

        BinaryTree.Node newRoot = specialPreOrderTraversal.constructTree(pre, preLN, binaryTree.getRoot());

        Assert.assertEquals(newRoot.key, 10);
        Assert.assertEquals(newRoot.getLeft().key, 30);
        Assert.assertEquals(newRoot.getRight().key, 15);
        Assert.assertEquals(newRoot.getLeft().getLeft().key, 20);
        Assert.assertEquals(newRoot.getLeft().getRight().key, 5);
    }
}