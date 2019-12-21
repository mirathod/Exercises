package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Add Description
 *
 * @author Milan Rathod
 */
public class TopViewTest {

    private BinaryTree binaryTree;

    private TopView topView;

    @Before
    public void setup() {
        topView = new TopView();
        binaryTree = new BinaryTree(1);
        binaryTree.getRoot().left = new BinaryTree.Node(2);
        binaryTree.getRoot().right = new BinaryTree.Node(3);
        binaryTree.getRoot().left.left = new BinaryTree.Node(4);
        binaryTree.getRoot().left.right = new BinaryTree.Node(5);
        binaryTree.getRoot().right.left = new BinaryTree.Node(6);
        binaryTree.getRoot().right.right = new BinaryTree.Node(7);
    }

    @Test
    public void testFind() {
        List<Integer> result = topView.find(binaryTree.getRoot());

        Assert.assertEquals(5, result.size());
    }
}