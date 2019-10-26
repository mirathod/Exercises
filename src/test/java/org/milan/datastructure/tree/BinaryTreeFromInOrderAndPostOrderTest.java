package org.milan.datastructure.tree;

import org.junit.Test;

/**
 * Test Class for {@link BinaryTreeFromInOrderAndPostOrder}
 *
 * @author Milan Rathod
 */
public class BinaryTreeFromInOrderAndPostOrderTest {

    @Test
    public void testBuildTree() {
        BinaryTreeFromInOrderAndPostOrder binaryTreeFromInOrderAndPostOrder = new BinaryTreeFromInOrderAndPostOrder();

        char[] inOrder = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char[] postOrder = new char[]{'D', 'E', 'B', 'C', 'F', 'A'};

        binaryTreeFromInOrderAndPostOrder.buildTree(inOrder, postOrder);
    }
}