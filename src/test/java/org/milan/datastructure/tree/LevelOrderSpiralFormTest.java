package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.milan.util.ListUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Test class for {@link LevelOrderSpiralForm}
 *
 * @author Milan Rathod
 */
public class LevelOrderSpiralFormTest {

    private BinaryTree binaryTree;

    private LevelOrderSpiralForm levelOrderSpiralForm;

    @Before
    public void setup() {
        levelOrderSpiralForm = new LevelOrderSpiralForm();
        binaryTree = new BinaryTree(1);
        binaryTree.getRoot().left = new BinaryTree.Node(2);
        binaryTree.getRoot().right = new BinaryTree.Node(3);
        binaryTree.getRoot().left.left = new BinaryTree.Node(4);
        binaryTree.getRoot().left.right = new BinaryTree.Node(5);
        binaryTree.getRoot().right.left = new BinaryTree.Node(6);
        binaryTree.getRoot().right.right = new BinaryTree.Node(7);
    }

    @Test
    public void testUsingTwoStacks() {
        List<Integer> result = levelOrderSpiralForm.usingTwoStacks(binaryTree.getRoot());

        Assert.assertTrue(ListUtil.isEqual(result, expectedResultList()));
    }

    @Test
    public void testUsingQueueAndStack() {
        List<Integer> result = levelOrderSpiralForm.usingQueueAndStack(binaryTree.getRoot());

        Assert.assertTrue(ListUtil.isEqual(result, expectedResultList()));
    }

    @Test
    public void testUsingDeque() {
        List<Integer> result = levelOrderSpiralForm.usingDeque(binaryTree.getRoot());

        Assert.assertTrue(ListUtil.isEqual(result, expectedResultList()));
    }

    private List<Integer> expectedResultList() {
        return Arrays.asList(1, 2, 3, 7, 6, 5, 4);
    }
}