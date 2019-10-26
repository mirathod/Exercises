package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Test class for {@link AncestorsOfNode}
 *
 * @author Milan Rathod
 */
public class AncestorsOfNodeTest {

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
    public void testFindAll() {
        AncestorsOfNode ancestorsOfNode = new AncestorsOfNode();

        List<BinaryTree.Node> result = ancestorsOfNode.findAll(binaryTree.getRoot(), 7);

        Assert.assertEquals(3, result.get(0).key);
        Assert.assertEquals(1, result.get(1).key);
    }

    @Test
    public void testFindAllIterative() {
        AncestorsOfNode ancestorsOfNode = new AncestorsOfNode();

        List<BinaryTree.Node> result = ancestorsOfNode.findAllIterative(binaryTree.getRoot(), 7);

        Assert.assertEquals(3, result.get(0).key);
        Assert.assertEquals(1, result.get(1).key);
    }
}