package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Test class for {@link Distance}
 *
 * @author Milan Rathod
 */
public class DistanceTest {

    private BinaryTree binaryTree;

    private Distance distance;

    @Before
    public void setup() {

        distance = new Distance();

        binaryTree = new BinaryTree(1);
        binaryTree.getRoot().left = new BinaryTree.Node(2);
        binaryTree.getRoot().right = new BinaryTree.Node(3);
        binaryTree.getRoot().left.left = new BinaryTree.Node(4);
        binaryTree.getRoot().left.right = new BinaryTree.Node(5);
        binaryTree.getRoot().right.left = new BinaryTree.Node(6);
        binaryTree.getRoot().right.right = new BinaryTree.Node(7);
    }

    @Test
    public void testFindDistance() {
        List<Integer> result = distance.findDistance(binaryTree.getRoot(), binaryTree.getRoot().left, 3);

        Assert.assertEquals(2, result.size());

        Assert.assertEquals(Arrays.asList(6, 7), result);
    }
}