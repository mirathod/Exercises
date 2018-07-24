package org.milan.test;
import java.util.Arrays;
import java.util.Scanner;


public class SubArrays{
    static int count=0;
    public static void main(String[] args) {
        
      Scanner in = new Scanner(System.in);
      int testCases = Integer.parseInt(in.nextLine());
        int[] myList = new int[testCases];
  
        int index=0;
      while(testCases>0){
         int id = in.nextInt();
        myList[index]=id;
          index++;
          testCases--;
      }
      in.close();
      for(int a:myList){
    	  System.out.println(a);
    	   }
      
      for(int i=0;i<myList.length;i++){
    	  for(int j=i;j<myList.length;j++){
    		  int k=0,m=i;
    		  int sum=0;
    		 int[] c=Arrays.copyOfRange(myList,i,j+1);
    		 while(k<c.length){
    			 sum+=myList[m];
    			 k++;
    			 m++;
    		 }
    		 System.out.println(sum);
    		 if(sum<0){
    			 count++;
    		 }
    }
    	  
}
      System.out.println("count"+count);
      
      
    }
}