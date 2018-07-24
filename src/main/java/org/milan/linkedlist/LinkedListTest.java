package org.milan.linkedlist;


import java.util.List;

import org.milan.linkedlist.LinkedListDemo.Node;

public class LinkedListTest {

		//Main method to perform all the test execution related to linkedlist
		public static void main(String[] args) {
			LinkedListDemo lld=new LinkedListDemo();
			lld.head=new Node(4);
			Node second=new Node(9);
			Node third=new Node(12);
			Node fourth=new Node(14);
			Node fifth=new Node(25);
			lld.head.next=second;
			second.next=third;
			third.next=fourth;
			fourth.next=fifth;
			fifth.next=lld.head;
			lld.printList(lld.head);
			
			LinkedListDemo lld2=new LinkedListDemo();
			lld2.head=new Node(5);
			Node s2=new Node(2);
			lld2.head.next=s2;
			//lld2.printList();
			lld.insertByCircularList(new Node(2));
			lld.printList(lld.head);
		}
		
		
			
}

