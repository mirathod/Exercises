package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link ConvertBinaryTree2SumTree}
 *
 * @author Milan Rathod
 */
public class ConvertBinaryTree2SumTreeTest {

    @Test
    public void testConvert() {
        ConvertBinaryTree2SumTree convertBinaryTree2SumTree = new ConvertBinaryTree2SumTree();

        BinaryTree binaryTree = new BinaryTree(10);
        binaryTree.getRoot().left = new BinaryTree.Node(-2);
        binaryTree.getRoot().right = new BinaryTree.Node(6);
        binaryTree.getRoot().left.left = new BinaryTree.Node(8);
        binaryTree.getRoot().left.right = new BinaryTree.Node(-4);
        binaryTree.getRoot().right.left = new BinaryTree.Node(7);
        binaryTree.getRoot().right.right = new BinaryTree.Node(5);

        convertBinaryTree2SumTree.convert(binaryTree.getRoot());

        Assert.assertEquals(20, binaryTree.getRoot().key);
        Assert.assertEquals(4, binaryTree.getRoot().left.key);
        Assert.assertEquals(12, binaryTree.getRoot().right.key);
    }
}