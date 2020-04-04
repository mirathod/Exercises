package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.milan.util.ListUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Test class for {@link TreeView}
 *
 * @author Milan Rathod
 */
public class TreeViewTest {

    private BinaryTree binaryTree;

    private TreeView treeView;

    @Before
    public void setup() {
        treeView = new TreeView();
        binaryTree = new BinaryTree(1);
        binaryTree.getRoot().left = new BinaryTree.Node(2);
        binaryTree.getRoot().right = new BinaryTree.Node(3);
        binaryTree.getRoot().left.left = new BinaryTree.Node(4);
        binaryTree.getRoot().left.right = new BinaryTree.Node(5);
        binaryTree.getRoot().right.left = new BinaryTree.Node(6);
        binaryTree.getRoot().right.right = new BinaryTree.Node(7);
    }

    @Test
    public void testTopView() {
        List<Integer> result = treeView.topView(binaryTree.getRoot());

        Assert.assertEquals(5, result.size());

        Assert.assertTrue(ListUtil.isEqual(result, Arrays.asList(4, 2, 1, 3, 7)));
    }

    @Test
    public void testLeftView() {
        List<Integer> result = treeView.leftView(binaryTree.getRoot());

        Assert.assertEquals(3, result.size());

        Assert.assertTrue(ListUtil.isEqual(result, Arrays.asList(1, 2, 4)));
    }

    @Test
    public void testLeftViewRecursive() {
        List<Integer> result = treeView.leftViewRecursive(binaryTree.getRoot());

        Assert.assertEquals(3, result.size());

        Assert.assertTrue(ListUtil.isEqual(result, Arrays.asList(1, 2, 4)));
    }

    @Test
    public void testRightView() {
        List<Integer> result = treeView.rightView(binaryTree.getRoot());

        Assert.assertEquals(3, result.size());

        Assert.assertTrue(ListUtil.isEqual(result, Arrays.asList(1, 3, 7)));
    }

    @Test
    public void testRightViewRecursive() {
        List<Integer> result = treeView.rightViewRecursive(binaryTree.getRoot());

        Assert.assertEquals(3, result.size());

        Assert.assertTrue(ListUtil.isEqual(result, Arrays.asList(1, 3, 7)));
    }

    @Test
    public void testBottomView() {
        List<Integer> result = treeView.bottomView(binaryTree.getRoot());

        Assert.assertEquals(5, result.size());

        Assert.assertTrue(ListUtil.isEqual(result, Arrays.asList(4, 2, 6, 3, 7)));
    }
}