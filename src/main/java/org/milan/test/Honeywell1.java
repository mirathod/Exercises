package org.milan.test;
import java.util.Scanner;

public class Honeywell1 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
        	arr[i]=s.nextInt();
        }
        int Q=s.nextInt();
        boolean[] swap=new boolean[N];
        System.out.println(Q);
        for(int i=0;i<Q;i++){
        	int source=s.nextInt();
        	int destination=s.nextInt();
        	for(int j=source-1;j<destination;j++){
        		swap[j]=!swap[j];
        	}
        }
        int relatedIndex=0,index=0;
        for(int i=0;i<N/2;i++){
        	relatedIndex=N-i-1;
        	if(swap[i]^swap[relatedIndex]){
        		index=i;
        		int temp=arr[index];
        		arr[index]=arr[relatedIndex];
        		arr[relatedIndex]=temp;
        	}
        }
        for(int value:arr){
        	System.out.println(value+" ");
        }
      }

}
