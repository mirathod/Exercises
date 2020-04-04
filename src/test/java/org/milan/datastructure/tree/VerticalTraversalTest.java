package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Test class for {@link VerticalTraversal}
 *
 * @author Milan Rathod
 */
public class VerticalTraversalTest {

    private VerticalTraversal verticalTraversal;

    private BinaryTree binaryTree;

    @Before
    public void setup() {
        verticalTraversal = new VerticalTraversal();
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
        List<String> result = verticalTraversal.traverse(binaryTree.getRoot());

        Assert.assertEquals(5, result.size());
    }
}