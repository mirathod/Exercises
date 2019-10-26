package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link ExpressionTree}
 *
 * @author Milan Rathod
 */
public class ExpressionTreeTest {

    @Test
    public void testConstructTree() {
        ExpressionTree expressionTree = new ExpressionTree();

        TreeNode<Character> root = expressionTree.constructTree("ABC*+D/".toCharArray());

        Assert.assertEquals('/', root.key.charValue());
        Assert.assertEquals('+', root.left.key.charValue());
        Assert.assertEquals('D', root.right.key.charValue());
    }
}