package org.milan.hackerEarth;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Old Cold Number
 * 
 * @author rathom1
 *
 */
public class OldColdNumber {

	private static Set<Integer> primeCounts = new HashSet<>();

	public static void main(String args[]) throws Exception {

		// Scanner
		Scanner s = new Scanner(System.in);
		int testCases = Integer.parseInt(s.nextLine());

		OldColdNumber oldColdNumber = new OldColdNumber();

		while (testCases > 0) {
			int elements = s.nextInt();
			int[] arr = new int[elements];
			for (int i = 0; i < elements; i++) {
				int number = s.nextInt();
				arr[i] = number;
				if (!primeCounts.contains(number)) {
					if ((number == 2 || number % 2 != 0) && oldColdNumber.isPrime(number)) {
						primeCounts.add(number);
					}
				}
			}

			int tasks = s.nextInt();
			while (tasks > 0) {
				int left = s.nextInt();
				int right = s.nextInt();
				System.out.println(oldColdNumber.computeBalancedSubArray(arr, left, right));
				tasks--;
			}
			testCases--;
		}
	}

	private int computeBalancedSubArray(int[] arr, int left, int right) {
		int oldNumber = 0;
		int coldNumber = 0;
		int index = left - 1;
		int thresoldForBalanced = ((right - left) / 2) + 1;

		while (index < right) {
			if (primeCounts.contains(arr[index])) {
				coldNumber++;
			} else {
				oldNumber++;
			}

			if (oldNumber == thresoldForBalanced) {
				return 0;
			}
			index++;
		}

		return thresoldForBalanced - oldNumber;

	}

	private boolean isPrime(int number) {
		boolean isPrime = true;
		for (int divisor = 2; divisor <= number / 2; divisor++) {
			if (number % divisor == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

}
