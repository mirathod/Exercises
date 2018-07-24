package org.milan.test;

public class AmazonFeb17 {

	public static void main(String[] args) {
		int[] arr=new int[]{15,20,2,30,3,35};
		int maxdiff=-2147483648;
		int ipos=-1,jpos=-1;
		int minpos=0,min=arr[0];
		for(int k=1;k<arr.length;k++){
			int diff=arr[k]-min;
			if(diff>maxdiff){
				maxdiff=diff;
				jpos=k;
				ipos=minpos;	
			}
			else if(arr[k]<min){
				min=arr[k];
				minpos=k;
			}
			
		}
		System.out.println(ipos+" "+jpos);
	}

}
