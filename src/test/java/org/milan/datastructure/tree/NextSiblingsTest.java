package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link NextSiblings}
 *
 * @author Milan Rathod
 */
public class NextSiblingsTest {

    private CustomNode root;

    @Before
    public void setup() {
        root = new CustomNode(1);
        root.left = new CustomNode(2);
        root.right = new CustomNode(3);
        root.left.left = new CustomNode(4);
        root.left.right = new CustomNode(5);
        root.right.left = new CustomNode(6);
        root.right.right = new CustomNode(7);
    }

    @Test
    public void testUpdateSiblings() {
        NextSiblings nextSiblings = new NextSiblings();

        CustomNode updatedRoot = nextSiblings.updateSiblings(root);

        Assert.assertEquals(updatedRoot.left.nextSibling.data, 3);
        Assert.assertEquals(updatedRoot.left.right.nextSibling.data, 6);

    }
}