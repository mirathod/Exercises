package org.milan.dataStructure;

public class FindDuplicates {
public static void main(String[] args) {
	
	int arr[]={1,2,3,0,4,2,4,0};
	new FindDuplicates().duplicate(arr);
	
}
public void duplicate(int[] a){
	
	for(int i=0;i<a.length;i++){
		if(a[Math.abs(a[i])]>0){
			a[Math.abs(a[i])]=-a[Math.abs(a[i])];
		}
		else if(a[Math.abs(a[i])]==0){
			continue;
		}
	else{
			System.out.print(Math.abs(a[i])+" ");
		}
		
	}
	
}
}
