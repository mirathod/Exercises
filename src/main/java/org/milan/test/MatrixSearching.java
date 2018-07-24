package org.milan.test;
import java.util.Scanner;

public class MatrixSearching {

	public static void main(String[] args) {
		Scanner sn=new Scanner(System.in);
		
		//No. of Test Cases
		int N=sn.nextInt();
		
		int testCaseCounter=0;
		while(testCaseCounter<N){
			int rows=sn.nextInt();
			int columns=sn.nextInt();
			int[][] matrix=new int[rows][columns];
			
			for(int i=0;i<rows;i++){
				for(int j=0;j<columns;j++){
					matrix[i][j]=sn.nextInt();
				}
			}
			int x=sn.nextInt();
			int i=0,j=columns-1;
			boolean flag=false;
			while(i<rows&&j>=0){
				if(matrix[i][j]==x){
					flag=true;
					break;
				}
				else if(matrix[i][j]>x){
					j--;
				}
				else{
					i++;
				}
			}
			if(flag==true){
				System.out.println("Key Location "+i+" "+j);
			}
			else{
				System.out.println("Key not found");
			}
			testCaseCounter++;
		}

	}

}
