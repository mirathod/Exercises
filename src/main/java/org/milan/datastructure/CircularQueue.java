package org.milan.datastructure;

public class CircularQueue {
	private static final int size=5;
	private Object[] q;
	private int front;
	private int rear;
public static void main(String[] args) {
	CircularQueue cq=new CircularQueue();
	cq.enqueue(5);
	cq.enqueue(10);
	cq.enqueue(15);
	cq.enqueue(20);
	cq.enqueue(25);
	cq.dequeue();
	cq.dequeue();
	cq.dequeue();
	cq.enqueue(30);
}
public CircularQueue(){
	front=-1;
	rear=-1;
	q=new Object[size];
}
public boolean isFull(){
	return (rear==front)?true:false;
}
public boolean isEmpty(){
	return (front==-1)?true:false;
}

public void enqueue(Object obj){
	rear=(rear+1)%size;
	if(isFull()){
		System.out.println("Queue is full");
		
	}
	else{
	q[rear]=obj;
	System.out.println("enqueue "+rear+" = "+obj);
	if(front==-1)front=0;
	}
	
}
public Object dequeue(){
	if(isEmpty()){
		System.out.println("Queue is empty");
		return null;
	}
	else{
	Object item=q[front];
	System.out.println("dequeue "+front+" = "+item);
	if(front==rear)front=rear=-1;
	front=(front+1)%size;
	return item;
	}
}
}
