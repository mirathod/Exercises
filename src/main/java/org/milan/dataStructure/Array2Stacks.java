package org.milan.dataStructure;

import java.lang.reflect.Array;

public class Array2Stacks{
	public static void main(String[] args) {
		Array2StacksDemo<Integer> a2s=new Array2StacksDemo<Integer>(Integer.class,10);
		a2s.push(1,5);
		a2s.pop(1);
		a2s.pop(2);
		
	}
}

class Array2StacksDemo<T> {
		
private T[] array;
private int top1;
private int top2;
private int capacity;

public Array2StacksDemo(Class<T> classT,int capacity) {
	super();
	

	array=(T[])Array.newInstance(classT, capacity);
	top1=-1;
	top2=capacity;
	this.capacity=capacity;
}
void push(int stack,T data){
	switch(stack){
	case 1:pushOne(data);break;
	case 2:pushTwo(data);break;
	default : throw new IllegalArgumentException("stack");
	}
	
}
T pop(int stack){
	switch(stack){
	case 1:return popOne();
	case 2:return popTwo();
	default :throw new IllegalArgumentException("stack");
	}
}
private void pushOne(T data){
	if(top2-top1<=1){
		throw new StackOverflowError("Stack 1");
	}
	else{
		array[++top1]=data;
		System.out.println("Push on Stack 1 :"+data);
		
	}
}
private void pushTwo(T data){
	if(top2-top1<=1){
		throw new StackOverflowError("Stack 2");
	}
	else{
		array[--top2]=data;
		System.out.println("Push on Stack 2 :"+data);
	}
}
private T popOne(){
	T t;
	if(top1<0){
		throw new StackUnderflowError("Stack 1");
	}
	else{
		t=array[top1];
		top1--;
		System.out.println("Pop from Stack 1 :"+t);
	}
	return t;
}
private T popTwo(){
	T t;
	if(top2>=capacity){
		throw new StackUnderflowError("Stack 2");
	}
	else{
		t=array[top2];
		top2++;
		System.out.println("Pop from Stack 2 :"+t);
	}
	return t;
}
}
class StackUnderflowError extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StackUnderflowError(String msg){
		super(msg);
	}
	
}
