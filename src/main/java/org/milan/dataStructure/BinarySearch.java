package org.milan.dataStructure;

/**
 * @author ghuser
 *
 */
public class BinarySearch {
	
	public static void main(String[] args) {
		int a[]={2,4,6,8,9,12,15,18};
		int search=new BinarySearch().binarySearch(a,11,a.length);
		if(search!=-1)
		System.out.println("Element found at index : "+search);
		else
		System.out.println("Element Not found");
		
	}
	int binarySearch(int a[],int X,int N){
		int low=0,high=N-1,mid;
		
		while(low<=high){
			mid=(low+high)/2;
			if(a[mid]<X)
				low=mid+1;
			else if(a[mid]>X)
				high=mid-1;
			else 
				return mid;
		}
		return -1;
	}


	
}
