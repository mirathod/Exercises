package org.milan.datastructure;

public class CountingSort {
public static void main(String[] args) {
	//int[] a=new int[]{1, 4, 1, 2, 7, 5, 2};
	int[] a=new int[]{170, 45, 75, 90, 80, 24, 2, 66};
	int[] b=new  CountingSort().sort(a);
	for(int i=0;i<b.length;i++){
		System.out.print(b[i]+",");
	}
}

//Complexity --O(n+m)--here m is 256
public int[] sort(int[] arr){
	int[] a=new int[arr.length];
	int count[] = new int[256];
	for(int i=0;i<arr.length;i++){
		count[arr[i]]++;
	}
	for(int i=1;i<count.length;i++){
		count[i]+=count[i-1];
	}
	for(int i=0;i<arr.length;i++){
		a[count[arr[i]]-1]=arr[i];
		--count[arr[i]];
	}
	return a;
}
}
