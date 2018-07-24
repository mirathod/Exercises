package org.milan.dataStructure;

public class CircularQueueDemo {
	private static final int size=5;
	private Object[] q;
	private int front;
	private int rear,count;
public static void main(String[] args) {
	CircularQueueDemo cq=new CircularQueueDemo();
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
public CircularQueueDemo(){
	front=0;
	rear=0;
	count=0;
	q=new Object[size];
}
public boolean isFull(){
	return (count==size)?true:false;
}
public boolean isEmpty(){
	return (count==0)?true:false;
}

public void enqueue(Object obj){
	if(isFull()){
		System.out.println("Queue is full");
		
	}
	else{
	q[rear]=obj;
	System.out.println("enqueue "+rear+" = "+obj);
	rear=(rear+1)%size;
	count++;
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
	front=(front+1)%size;
	count--;
	return item;
	}
}
}
