package org.milan.datastructure.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr=new int[]{23,12,3,56,77,44,13,99};
		arr=new BubbleSort().bubbleSorting(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}


	}
	public int[] bubbleSorting(int[] arr){
		for(int i=0;i<arr.length;i++){
			int flag=0;
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					flag=1;
				}
			}
			if(flag==0)break;
		}
		return arr;
	}

}