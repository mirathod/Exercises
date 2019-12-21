package org.milan.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for {@link ConvertBST2DLL}
 *
 * @author Milan Rathod
 */
public class ConvertBST2DLLTest {

    private BinarySearchTree binarySearchTree;

    private ConvertBST2DLL convertBST2DLL;

    @Before
    public void setup() {
        binarySearchTree = new BinarySearchTree(20);

        binarySearchTree.insert(10);
        binarySearchTree.insert(15);
        binarySearchTree.insert(5);
        binarySearchTree.insert(30);
        binarySearchTree.insert(35);
        binarySearchTree.insert(25);

        convertBST2DLL = new ConvertBST2DLL();
    }

    @Test
    public void testConvert() {
        BinarySearchTree.Node head = convertBST2DLL.convert(binarySearchTree.getRoot());

        Assert.assertEquals(5, head.key);
    }

    @Test
    public void testConvertV2() {
        BinarySearchTree.Node head = convertBST2DLL.convertV2(binarySearchTree.getRoot());

        Assert.assertEquals(5, head.key);
    }
}