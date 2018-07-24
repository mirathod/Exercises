package org.milan.dataStructure;

public class InfixToPostfix {
	private static int top=-1;
	static String input="a+b*c+(d*e+f)*g";
	static String output="";
	static char a[]=new char[input.length()];
public static void main(String[] args) {
	
	for(int i=0;i<input.length();i++){
		Character c=input.charAt(i);
		if(Character.isLetter(c)){
			output+=c;
		}
		else if (c=='(')
			//push '('
			{
			 push(c);
			}
		else if (c==')')
			//pop everything back from stack till '('
			{
				while (peek() != '(')
				{
					output+=pop();
				}
				pop();		//remove '('
			}
			else
			//print operators occurring before it that have greater precedence
			{
                 while (!isEmpty() && !(peek()=='(') && precedence(c) <= precedence(peek()))
					output+= pop();
				
				push(c);
			}
 }
	while(!isEmpty()){
		output+=pop();
	}
	System.out.println(output);
}
public static int precedence(char x){
	if(x=='+'||x=='-')
		return 1;
	if(x=='*'||x=='/'||x=='%')
		return 2;
	return 0;
}

public static void push(char n){
	if(top>=a.length-1){
		System.out.println("Stack is Full");
	}
	else{
		a[++top]=n;
		System.out.println("Push : "+a[top]);
	}
}
public static char pop(){
	char n;
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
public static boolean isEmpty(){
	return (top==-1)?true:false;
}
public static char peek(){
	return a[top];
}
}
