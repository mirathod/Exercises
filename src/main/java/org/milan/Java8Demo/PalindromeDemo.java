package org.milan.Java8Demo;

import org.milan.binarytree.BinaryTreeDemo;

public class PalindromeDemo {

	public static void main(String args[] ) {
		
		String input="1234";
		int output=0,mul=1;
		for(int i=input.length()-1;i>=0;--i){
			int temp=input.charAt(i)-'0';
			output+=temp*mul;
			mul*=10;
		}
		System.out.println(output);
		
	    System.out.println(new PalindromeDemo().palindromeString("aba")); 
	    System.out.println(new PalindromeDemo().palindromeNumber(13431));
	  }

	    boolean palindromeString(String str){
	    	String output="";
	    	for(int i=str.length()-1;i>=0;i--){
	    		output+=str.charAt(i);
	    	}
	    	if(str.equals(output))return true;
	    	return false;
	    }
	    boolean palindromeNumber(int number){
	    	int input=number,output=0,mul=1;
	    	while(number>0){
	    		int temp=number%10;
	    		output+=temp*mul;
	    		mul*=10;
	    		number/=10;
	    	}
	    	if(input==output)return true;
	    	return false;
	    }
	    

}
