package org.milan.test;

public class GFG1 {

	public static void main(String[] args) {
		
		int[] arr=new int[]{1, 2, 0, 4, 3, 5};
		arr=calculate(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	static int[] calculate(int[] arr){
		int count=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=0){
				arr[count++]=arr[i];			
			}
			if(count-1!=i)arr[i]=0;
		}
		return arr;
	}
	
	
}
