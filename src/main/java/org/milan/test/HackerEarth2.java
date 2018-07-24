package org.milan.test;


import java.util.ArrayList;
import java.util.List;

public class HackerEarth2 {
	Node head;
	
	//Node Class to represent Node in LinkedList
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data=d;
			next=null;
		}
		
	}

	public static void main(String[] args) {
		int m=3,n=2;
		List<Node> list=new ArrayList<>();
		for(int i=1;i<=2;i++){
			if(list.contains(i)){
				
			}
		}
		

	}
	public void afterSpecifiedNode(Node previousNode,int data){
		if(previousNode==null){
			System.out.println("Previous node cannot be null");
			return;
		}
		Node newHead=new Node(data);
		newHead.next=previousNode.next;
		previousNode.next=newHead;
	}
	public void detectLoop(Node node,boolean flag){
		Node slow=node,fast=node;
		while(slow!=null&&fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				System.out.println("Loop existed");
			}
		}
		System.out.println("Loop doesnt't exist");
		
		
	}
	

}
