package org.milan.sample;

import java.util.Scanner;

/**
 * Problem:- Array: [12, 1, 13, 24, 12, 66, 12], X: 12 Replace X with 1 and move
 * remaining integers to last. Output: [1, 1, 1, 1, 13, 24, 66]
 *
 * @author rathom1
 *
 */
public class ShiftArray {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		// Elements
		int elements = s.nextInt();

		int[] inputArray = new int[elements];

		for (int i = 0; i < elements; i++) {
			inputArray[i] = s.nextInt();
		}

		int elementToRemove = s.nextInt();

		int[] outputArray = computeFinalArray(inputArray, elementToRemove);

		printFinalArray(outputArray);

	}

	private static int[] computeFinalArray(int[] inputArray, int X) {
		int pointer = inputArray.length - 1;

		for (int i = pointer; i >= 0; --i) {
			if (inputArray[i] != X) {
				inputArray[pointer--] = inputArray[i];
			}
		}

		while (pointer >= 0) {
			inputArray[pointer--] = 1;
		}
		return inputArray;
	}

	private static void printFinalArray(int[] outputArray) {
		for (int i = 0; i < outputArray.length; i++) {
			System.out.print(outputArray[i] + " ");
		}
	}

}
