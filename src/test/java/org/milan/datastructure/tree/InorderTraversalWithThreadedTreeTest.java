package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Test class for {@link InorderTraversalWithThreadedTree}
 *
 * @author Milan Rathod
 */
public class InorderTraversalWithThreadedTreeTest {

    private BinaryTree binaryTree;

    @Before
    public void setup() {
        binaryTree = new BinaryTree(4);
        binaryTree.getRoot().left = new BinaryTree.Node(7);
        binaryTree.getRoot().right = new BinaryTree.Node(5);
        binaryTree.getRoot().left.right = new BinaryTree.Node(1);
        binaryTree.getRoot().right.left = new BinaryTree.Node(11);
        binaryTree.getRoot().right.right = new BinaryTree.Node(6);
    }

    @Test
    public void testTraverse() {
        InorderTraversalWithThreadedTree inorderTraversalWithThreadedTree = new InorderTraversalWithThreadedTree();

        List<Integer> traversals = inorderTraversalWithThreadedTree.traverse(binaryTree.getRoot());

        Assert.assertEquals(7, traversals.get(0).intValue());
    }
}