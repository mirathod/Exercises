package org.milan.dataStructure;

public class StackDemo {
	private int top=-1;
	private int[] a=new int[100];
public static void main(String[] args) {
}
public void push(int n){
	if(top>=a.length-1){
		System.out.println("Stack is Full");
	}
	else{
		a[++top]=n;
		System.out.println("Push : "+a[top]);
	}
}
public int pop(){
	int n;
	if(top<0){
		System.out.println("Stack is empty");
		return 0;
	}
	else{
		n=a[top];
		System.out.println("Pop : "+n);
		top--;
	}
	return n;
}	
}
