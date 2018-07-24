package org.milan.Java8Demo;

import java.util.regex.Pattern;

public class CareerCup_P1 {
	
	public static void main(String[] args) {
		String output="";
		char previous=0;
		String str="a4b2c2a3f1g2";
		char[] ch=str.toCharArray();
		for(int i=0;i<ch.length;i++){
			String s=String.valueOf(ch[i]);
			if(Pattern.matches("[a-zA-Z]",s))
			{
				previous=ch[i];
				
			}
			else{
				output+=compute(previous,Integer.parseInt(s));
				previous=0;
			}
	}

		System.out.println(output);
	}
	static String compute(char c,int n){
		String output="";
		for(int i=0;i<n;i++){
			output+=c;
		}
		return output;
	}

}
