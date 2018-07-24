package org.milan.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedListDemo {

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
	
	//Insert scenario 1: To insert node before head
	public void insertBeforeHead(int data){
		Node newHead=new Node(data);
		newHead.next=this.head;
		this.head=newHead;
	}
	
	//Insert scenario 2: To insert node between two nodes
	public void afterSpecifiedNode(Node previousNode,int data){
		if(previousNode==null){
			System.out.println("Previous node cannot be null");
			return;
		}
		Node newHead=new Node(data);
		newHead.next=previousNode.next;
		previousNode.next=newHead;
	}
	
	//Insert scenario 3: To insert node at the end of list
	public void insertAtEnd(int data){
		Node newHead=new Node(data);
		if(this.head==null){
			System.out.println("LinkedList is empty");
			return;
		}
		Node last=head;
		while(last.next!=null){
			last=last.next;
		}
		last.next=newHead;
	}
	
	//To delete node from linkedlist
	public void deleteNode(int data){
		Node temp=head,previous=null;
		
		//If node to be deleted is head node
		if(temp!=null&&temp.data==data){
			head=temp.next;
			return;
		}
		
		//logic to identify the deletion node
		while(temp!=null&&temp.data!=data){
			previous=temp;
			temp=temp.next;
		}
		
		if(temp==null){
			System.out.println("Node with key "+data+" is not present in linkedlist");
			return;
		}
		previous.next=temp.next;
	}
	
	//Delete node from linkedlist by index
	public void deleteNodeByIndex(int index){
		
		if(index==0){
			head=head.next;
			return;
		}
		
		int targetIndex=1;
		Node temp=head.next,previous=head;
		while(targetIndex!=index){
			if(temp==null){
				System.out.println("Node with index "+index+" is not present in linkedlist");
				return;
			}
			previous=temp;
			temp=temp.next;
			targetIndex++;
		}
		previous.next=temp.next;
		
	}
	
	//To calculate size of linkedlist - iterative approach
	public int sizeByIterative(){
		int count=0;
		Node temp=head;
		if(temp==null){
			System.out.println("Linkedlist is empty");
			return -1;
		}
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		return count;
	}
	
	//To calculate size of linkedlist - recursive approach
	public int sizebyRecursive(Node head){
		if(head==null){
			return 0;
		}
		else{
			return 1+sizebyRecursive(head.next);
		}
	}
	
	public void swap(int x,int y){
		if(x==y){
			System.out.println("Both nodes are same, no changes required");
			return;
		}
		Node currentX=head,previousX=null;
		while(currentX!=null && currentX.data!=x){
			previousX=currentX;
			currentX=currentX.next;
		}
		Node currentY=head,previousY=null;
		while(currentY!=null && currentY.data!=y){
			previousY=currentY;
			currentY=currentY.next;
		}
		if(currentX==null || currentY==null){
			System.out.println("one of the nodes are not present in linkedlist");
			return;
		}
		if(previousX!=null)
			previousX.next=currentY;
		else
			head=currentY;
		if(previousY!=null)
			previousY.next=currentX;
		else
			head=currentX;
		
		//Do the swapping
		Node temp=currentX.next;
		currentX.next=currentY.next;
		currentY.next=temp;
	}
	
	//Reverse the linkedlist - iterative approach
	public void reverseByIterative(){
		Node current=head,prev=null,next=null;
		while(current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			
		}
		head=prev;
	}
	
	//Reverse the linkedlist - recursive approach
	public Node reverseByRecursive(Node curr,Node prev){
		if(curr.next==null){
			head=curr;
			curr.next=prev;
			return null;
		}
		Node first=curr.next;
		curr.next=prev;
		reverseByRecursive(first, curr);
		return head;
	}
	
	//Merge two linkedlist - iterative approach
	public Node MergeListByIterative(Node l1,Node l2){
		
		Node current1=l1;
		Node current2=l2;
		
		Node temp,tail;
		if(current1.data<current2.data){
			temp=current1;
			current1=current1.next;
		}
		else{
			temp=current2;
			current2=current2.next;
		}
		
		tail=temp;
		while(current1!=null && current2!=null){
			if(current1.data<=current2.data){
				temp.next=current1;
				//System.out.println(temp.data);
				current1=current1.next;	
			}
			else if(current1.data>current2.data){
				temp.next=current2;
				//System.out.println(temp.data);
				current2=current2.next;
			}
			temp=temp.next;
		}
		if(null == current1){
            current1 = temp;
            temp.next = current2;
        }
        else{
            current2 = temp;
            temp.next = current1;
        }
		return tail;
	}
	
	//Merge two linkedlist - recursive approach
	public Node MergeListByRecursive(Node head1, Node head2){
			
			
			if(head1 == null){
				return head2;
			}
			
			if(head2 == null){
				return head1;		
			}

			Node current = null;
			
			if(head1.data < head2.data){
					current = head1;
					current.next  = MergeListByRecursive(head1.next, head2);
				}else{
					current = head2;
					current.next  = MergeListByRecursive(head1, head2.next);
				}
			
			return current;
	}
	
	//Reverse a linked list in group of given size
	public Node reverseByGroupSize(Node head,int size){
		Node current=head,prev=null,next=null;
		int count=0;
		while(count<size&&current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			count++;
		}
		if(next!=null)
			head.next=reverseByGroupSize(next, size);
		return prev;
	}
	
	//To detect the loop in linkedlist
	public void detectLoop(Node node,boolean flag){
		Node slow=node,fast=node;
		while(slow!=null&&fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				System.out.println("Loop existed");
				if(flag){
					removeLoop(slow,node);
				}
				return;
			}
		}
		System.out.println("Loop doesnt't exist");
		
		
	}
	
	//remove detected loop based on boolean flag
	public void removeLoop(Node loop,Node current){
		Node ptr1=current;
		while(true){
			Node ptr2=loop;
			while(ptr2.next!=loop&&ptr2.next!=ptr1){
				ptr2=ptr2.next;
			}
			if(ptr2.next==ptr1){
				ptr2.next=null;
				return;
			}
			ptr1=ptr1.next;
		}
	}
	
	//add contents of two linked lists
	public Node addTwoLinkedList(Node n1,Node n2,int carry){
		int x=0,y=0;
		if(n1==null&&n2==null)return null;
		if(n1!=null){
			x=n1.data;
			n1=n1.next;
		}
		if(n2!=null){
			y=n2.data;
			n2=n2.next;
		}
		int z=x+y+carry;
		if(z>9){
			carry=z/10;
			z%=10;
			
		}
		else{
			carry=0;
		}
		Node n=new Node(z);
		n.next=addTwoLinkedList(n1, n2, carry);
		return n;
	}
	
	//
	public Node rotate(Node head,int k){
		int count=1;
		Node temp=head,newHead;
		while(count<k){
			temp=temp.next;
			count++;
		}
		newHead=temp.next;
		Node tail=newHead;
		temp.next=null;
		while(tail.next!=null){
			tail=tail.next;
		}
		tail.next=head;
		return newHead;
	}
	
	//Circular Linked list - split into two halved
	public List<Node> split(Node head){
		Node ptr1=head,ptr2=head,head1=null,head2=null;
		while(ptr2.next!=head&&ptr2.next.next!=head){
			ptr2=ptr2.next.next;
			ptr1=ptr1.next;
		}
		if(ptr2.next.next==head){
			ptr2=ptr2.next;
		}
		head1=head;
		if(head.next!=head)head2=ptr1.next;
		ptr2.next=ptr1.next;
		ptr1.next=head;
		List<Node> l=new ArrayList<>();
		l.add(head1);
		l.add(head2);
		return l;
	}
	
	//Insert new node into the circular linked list
	public void insertByCircularList(Node node){
		Node current=head;
		if(current==null){
			node.next=node;
			head=node;
		}
		else if(node.data<=current.data){
			while(current.next!=head){
				current=current.next;
			}
			current.next=node;
			node.next=head;
			head=node;
		}
		else{
			while(current.next!=head&&current.next.data<node.data){
				current=current.next;
			}
			node.next=current.next;
			current.next=node;	
		}
	}
	
	
	//To print linkedlist
	public void printList(){
		Node n=head;
		while(n!=null){
			System.out.print(n.data+"-->");
			n=n.next;
		}
		System.out.println("null");
	}
	
	//To print singly linkedlist
	public void printList(Node node){
		Node temp=node;
		if(temp!=null){
			do{
				System.out.print(temp.data+"-->");
				temp=temp.next;
			}while(temp!=node);
			System.out.println();
			
		}
	}
}
