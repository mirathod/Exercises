package org.milan.datastructure;

public class PostFixDemo {
	private static int top=-1;
	static String s="6523+8*+3+*";
	static int a[]=new int[s.length()];
	
public static void main(String[] args) {
	for(int i=0;i<s.length();i++){
		Character c=s.charAt(i);
		if(Character.isDigit(c)){
			int n=Character.getNumericValue(c);
			push(n);
		}
		else{
			int x=pop();
			int y=pop();
			int z=0;
			switch(c){
			case '+': z=x+y;break;
			case '*': z=x*y;break;
			case '-': z=x-y;break;
			case '/': z=x/y;break;
			}
			push(z);
		}
	}
	}
public static void push(int n){
	if(top>=a.length-1){
		System.out.println("Stack is Full");
	}
	else{
		a[++top]=n;
		System.out.println("Push : "+a[top]);
	}
}
public static int pop(){
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
