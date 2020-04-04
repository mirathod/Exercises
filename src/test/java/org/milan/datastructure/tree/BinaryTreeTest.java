package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link BinaryTree}
 *
 * @author Milan Rathod
 */
public class BinaryTreeTest {

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
    public void testFindMaximumElement() {
        int result = binaryTree.findMaximumElement(binaryTree.getRoot());

        Assert.assertEquals(11, result);
    }

    @Test
    public void testFindMaximumElementIterative() {
        int result = binaryTree.findMaximumElementIterative(binaryTree.getRoot());

        Assert.assertEquals(11, result);
    }

    @Test
    public void testFindMinimumElement() {
        int result = binaryTree.findMinimumElement(binaryTree.getRoot());

        Assert.assertEquals(1, result);
    }

    @Test
    public void testIsPresent() {
        Assert.assertTrue(binaryTree.isPresent(binaryTree.getRoot(), 11));

        Assert.assertFalse(binaryTree.isPresent(binaryTree.getRoot(), 3));
    }

    @Test
    public void testIsPresentIterative() {
        Assert.assertTrue(binaryTree.isPresentIterative(binaryTree.getRoot(), 11));

        Assert.assertFalse(binaryTree.isPresentIterative(binaryTree.getRoot(), 3));
    }

    @Test
    public void testMirrorTreeIterative() {
        binaryTree.mirrorTreeIterative(binaryTree.getRoot());

        Assert.assertTrue(binaryTree.isIdentical(binaryTree.getRoot(), getMirrorBinaryTree().getRoot()));
    }

    @Test
    public void testMirrorTree() {
        BinaryTree.Node mirrorTreeRoot = binaryTree.mirrorTree(binaryTree.getRoot());

        Assert.assertTrue(binaryTree.isIdentical(mirrorTreeRoot, getMirrorBinaryTree().getRoot()));
    }

    @Test
    public void testIsMirror() {
        Assert.assertTrue(binaryTree.isMirror(binaryTree.getRoot(), getMirrorBinaryTree().getRoot()));
    }

    private BinaryTree getMirrorBinaryTree() {
        BinaryTree mirrorBinaryTree = new BinaryTree(4);

        mirrorBinaryTree.getRoot().left = new BinaryTree.Node(5);
        mirrorBinaryTree.getRoot().right = new BinaryTree.Node(7);
        mirrorBinaryTree.getRoot().right.left = new BinaryTree.Node(1);
        mirrorBinaryTree.getRoot().left.left = new BinaryTree.Node(6);
        mirrorBinaryTree.getRoot().left.right = new BinaryTree.Node(11);

        return mirrorBinaryTree;
    }

}