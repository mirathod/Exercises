package org.milan.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
	int key;
	Node left,right;
	Node(int key){
		this.key=key;
		left=right=null;
	}
	public String toString(){
		return ""+this.key;
	}
}

public class BinaryTree {

	Node root;
	public BinaryTree(int key){
		root=new Node(key);
	}
	public BinaryTree(){
		root=null;
	}
	public int height(Node root){
		if(root==null)return 0;
		else{
			int lheight=height(root.left);
			int rheight=height(root.right);
			if(lheight>rheight)return (lheight+1);
			else return (rheight+1);
		}
	}
	public int size(Node root){
		if(root==null)return 0;
		else{
			return size(root.left)+size(root.right)+1;
		}
	}
	public void printLevelOrder(){
		int height=height(root);
		for(int i=1;i<=height;i++){
			printGivenLevel(root, i);
		}
	}
	public void printLevelOrderV2(){
		Queue<Node> queue=new LinkedList<>();
		Node temp=root;
		while(temp!=null){
			System.out.println(temp.key);
			if(temp.left!=null)queue.add(temp.left);
			if(temp.right!=null)queue.add(temp.right);
			temp=queue.poll();
		}
	}
	public void preOrder(Node N){
		if(N == null) return;
		System.out.print(N.key+"  ");
		preOrder(N.left);
		preOrder(N.right);
	}
	public void inOrder(Node N){
		if(N == null) return;
		inOrder(N.left);
		System.out.print(N.key+"  ");
		inOrder(N.right);
	}
	public void postOrder(Node N){
		if(N == null) return;
		postOrder(N.left);
		postOrder(N.right);
		System.out.print(N.key+"  ");
	}
	
	public int getLeafNode(Node node){
		if(node==null)return 0;
		else if(node.left==null&&node.right==null)return 1;
		else{
			return getLeafNode(node.left)+getLeafNode(node.right);
		}
	}
	
	public boolean checkSum(Node node){
		if(node==null)return false;
		else{
			Queue<Node> queue=new LinkedList<>();
			queue.add(node);
			
			while(!queue.isEmpty()){
				int ld=0,rd=0;
				Node temp=queue.poll();
				if(temp.left==null&&temp.right==null)continue;
				if(temp.left!=null){
					ld=temp.left.key;
					queue.add(temp.left);
				}
				if(temp.right!=null){
					rd=temp.right.key;
					queue.add(temp.right);
				}
				if(temp.key==ld+rd){
					continue;
				}
				else{
					return false;
				}
			}
		}
		return true;
	}
	
	public void arbitaryTree(Node node){
		if(node==null)return;
		else{
			int ld=0,rd=0;
			if(node.left!=null)ld=node.left.key;
			if(node.right!=null)rd=node.right.key;
			int diff=node.key-(ld+rd);
			if(diff>0){
				if(node.left!=null){
					node.left.key+=diff;
				}
				else if(node.right!=null){
					node.right.key+=diff;
				}
				else{
				System.out.println(node.key);
				return;
				}
			}
			else{
				node.key-=diff;
			}
			System.out.println(node.key);
			arbitaryTree(node.left);
			arbitaryTree(node.right);
		}
	}
	
	public int sumTree(Node node){
		if(node==null||(node.left==null&&node.right==null))return 1;
		else{
			int leftSubTree=sum(node.left);
			int rightSubTree=sum(node.right);
			if((node.key==leftSubTree+rightSubTree)&&sumTree(node.left)!=0&&sumTree(node.right)!=0){
				return 1;
			}
		}
		return 0;
	}
	public int sum(Node node){
		if (node == null)
            return 0;
        return sum(node.left) + node.key+ sum(node.right);
	}
	
	void printGivenLevel(Node root,int level){
		if(root==null)return;
		if(level==1)System.out.println(root.key+" ");
		else if(level>1){
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}
	
	public void postOrderWithTwoStacks(Node node){
		Stack<Node> stack1=new Stack<>();
		Stack<Node> stack2=new Stack<>();
		stack1.push(node);
		while(!stack1.isEmpty()){
			Node temp=stack1.pop();
			stack2.push(temp);
			if(temp.left!=null)stack1.push(temp.left);
			if(temp.right!=null)stack1.push(temp.right);
		}
		while(!stack2.isEmpty()){
			System.out.println(stack2.pop().key+" ");
		}
 	}
	public void postOrderWithOneStack(Node node){
		Stack<Node> stack=new Stack<>();
		do{
			while(node!=null){
				if(node.right!=null)stack.push(node.right);
				stack.push(node);
				node=node.left;
			}
			node=stack.pop();
			if(node.right!=null&&(stack.isEmpty()==false&&node.right==stack.peek())){
				Node temp=stack.pop();
				stack.push(node);
				node=temp;
			}
			else{
				System.out.println(node.key);
				node=null;
			}
		}while(!stack.isEmpty());
	}
	
	
}
