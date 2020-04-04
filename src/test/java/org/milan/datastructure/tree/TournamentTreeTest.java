package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link TournamentTree}
 *
 * @author Milan Rathod
 */
public class TournamentTreeTest {

    @Test
    public void testSecondMin() {
        BinaryTree binaryTree = new BinaryTree(2);
        binaryTree.getRoot().left = new BinaryTree.Node(2);
        binaryTree.getRoot().right = new BinaryTree.Node(5);
        binaryTree.getRoot().left.left = new BinaryTree.Node(2);
        binaryTree.getRoot().left.right = new BinaryTree.Node(4);
        binaryTree.getRoot().right.left = new BinaryTree.Node(5);
        binaryTree.getRoot().right.right = new BinaryTree.Node(7);

        TournamentTree tournamentTree = new TournamentTree();

        int result = tournamentTree.secondMin(binaryTree.getRoot());

        Assert.assertEquals(4, result);
    }
}