package org.milan.binarysearchtree;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		BinarySearchTree bst=new BinarySearchTree(20);
		bst.root.left=new Node(15);
		bst.root.left.left=new Node(10);
		bst.root.left.left.left=new Node(5);
		//bst.root.left.right=new Node(-8);
		bst.root.right=new Node(25);
		//bst.root.right.left=new Node(13);
		bst.root.right.right=new Node(30);
		//bst.root.right.left.left=new Node(5);
		
		bst.rightViewOfTree(bst.root, 1);
	}

}
