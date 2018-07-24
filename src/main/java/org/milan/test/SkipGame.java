package org.milan.test;
import java.util.Arrays;
import java.util.Scanner;



public class SkipGame{

	public static void main(String[] args){
		 Scanner in = new Scanner(System.in);
	      int testCases = Integer.parseInt(in.nextLine());
	      while(testCases>0){
	    	  
	    	  
	    	  int n = in.nextInt();
	    	  int m = in.nextInt();
	    	
	    	  int[] myList = new int[n];
	    	  int index=0;
	    	  while(n>0){
	 	         int id = Integer.parseInt(in.next());
	 	        myList[index]=id;
	 	          index++;
	 	          n--;
	 	      }
	    	  int k=0,i=1;
	    	  while(true){
	    		  if(myList.length!=i && myList[i]==0)
	    		  i++;
	    		  else if(myList.length==i)
	    			  break;
	    		  else
	    		break;	  
	    	  }
	    	  if(i>myList.length || (i+m)>myList.length){
	    		  System.out.println("YES");
	    	  }
	    	  else{
	    		  System.out.println("NO");
	    	  }
	      }
	    in.close();
	      }
	}			
 


	

