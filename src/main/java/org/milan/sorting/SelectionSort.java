package org.milan.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr=new int[]{23,12,3,56,77,44,13,99};
		arr=new SelectionSort().selectionSorting(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}

	}
	
	public int[] selectionSorting(int[] arr){
		for(int i=0;i<=arr.length-2;i++){
			int min=i;
			for(int j=i+1;j<=arr.length-1;j++){
				if(arr[j]<arr[min]){
					min=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
		return arr;
		
	}

}
