package org.milan.test;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SkipGameDemo{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
	      int testCases = Integer.parseInt(in.nextLine());
	      while(testCases>0){
              int i=0;
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
        if(isSolvable(m,myList,i)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
	    	  }
    }
   private static boolean isSolvable(int m, int[] arr, int i) {
    if (i < 0 || arr[i] == 1) return false;
    if ((i == arr.length - 1) || i + m > arr.length - 1) return true;

    arr[i] = 1;
    return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
}
}