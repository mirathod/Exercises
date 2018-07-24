package org.milan.test;

public class ArrayIsFull {
public static void main(String[] args) {
	int[] a=new int[5];
	int s=0;
	for(int i=0;i<a.length;i++){
		try{
			a[++i]=s;
			s++;
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Array is Full");
			System.exit(0);
		}
	}
}
}
