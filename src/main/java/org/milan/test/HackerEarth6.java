package org.milan.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class HackerEarth6 {
public static void main(String[] args) {
	
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    System.out.println(n);
    int m=s.nextInt();
    System.out.println(m);
    int a[]=new int[n];
    while(m>0){
    	int op=s.nextInt();
    	if(op==1){
    		int i=s.nextInt();
    		int k=s.nextInt();
    		a[i]=k;
    	}
    	else{
    		int p=s.nextInt();
    		new HackerEarth6().count(a,p);
    	}
    }
}
private long count(int[] a,int p){
	int[] arr=new int[p];
	long sum=0;
	for(int i:a){
		
	}
	return 0;
}

}
