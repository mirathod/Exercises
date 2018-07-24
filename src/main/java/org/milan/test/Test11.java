package org.milan.test;

import java.util.Scanner;

public class Test11{

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		// Elements
		int elements = s.nextInt();
		
		int[] inputArray = new int[elements];
		
		for (int i=0; i<elements; i++) {
			inputArray[i] = s.nextInt();
		}
		
		int elementToRemove = s.nextInt();
		
		int[] outputArray = computeFinalArray(inputArray, elementToRemove);
		
		printFinalArray(outputArray);

	}
	
	private static int[] computeFinalArray(int[] inputArray, int X) {
		int pointer = inputArray.length-1;
		
		for (int i=pointer; i>=0; --i) {
			if (inputArray[i] != X) {
				inputArray[pointer--] = inputArray[i];
			} 
		}
		
		while (pointer >=0) {
			inputArray[pointer--] = 1;
		}
		return inputArray;
	}
	
	private static void printFinalArray(int[] outputArray) {
		for (int i=0; i<outputArray.length; i++) {
			System.out.print(outputArray[i] + " ");
		}
	}

}
