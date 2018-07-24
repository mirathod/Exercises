package org.milan.test;
import java.util.Scanner;
import java.util.Stack;

//Hacker Earth Problem: Balance Brackets
public class HackerEarth4 {

@SuppressWarnings("resource")
public static void main(String args[] ) throws Exception {
        
		Scanner sn = new Scanner(System.in);
        String input = sn.nextLine();
        
        int n=sn.nextInt();
        int out = 0;
        
        Stack<String> st=new Stack<>();
        
        if(n==2)
        {                
             for(int i=0;i<input.length();i++)
             {                    
                 if(input.charAt(i)=='(')
                 {
                      if(st.empty())out=0;                         
                      st.push("(");
                      out++;
                 }                     
                 else
                 {
                      st.pop();
                 }                                          
             }
        }
      else
        {
             for(int i=input.length()-1;i>=0;i--)
             {                    
                 if(input.charAt(i)==')')
                 {
                      if(st.empty())out=0;                           
                     st.push(")");
                     out++;
                 }
                 
                 else
                 {
                      st.pop();
                 }   
             }    
        }
        System.out.println(out);
} 
}
