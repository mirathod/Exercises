package org.milan.datastructure.binarytree;


import org.milan.datastructure.binarysearchtree.Node;

public class BinaryTreeDemo {

    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree(26);
        bt.root.left = new Node(10);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(6);
        bt.root.right.left = new Node(3);
        //bt.root.right.right=new Node(30);
        //bt.preOrder(bt.root);
        //bt.postOrder(bt.root);
        bt.postOrderWithOneStack(bt.root);

    }
}	
