package org.milan.datastructure.tree;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * Test Class for {@link VerticalSum}
 *
 * @author Milan Rathod
 */
public class VerticalSumTest {

    private BinaryTree binaryTree;

    private VerticalSum verticalSum;

    @Before
    public void setup() {
        verticalSum = new VerticalSum();
        binaryTree = new BinaryTree(1);
        binaryTree.getRoot().left = new BinaryTree.Node(2);
        binaryTree.getRoot().right = new BinaryTree.Node(3);
        binaryTree.getRoot().left.left = new BinaryTree.Node(4);
        binaryTree.getRoot().left.right = new BinaryTree.Node(5);
        binaryTree.getRoot().right.left = new BinaryTree.Node(6);
        binaryTree.getRoot().right.right = new BinaryTree.Node(7);
    }

    @Test
    public void testComputeSum() {
        List<Integer> result = verticalSum.computeSum(binaryTree.getRoot());

        Collections.sort(result);

        Assert.assertEquals(result,Lists.newArrayList(2, 3, 4, 7, 12));
    }
}