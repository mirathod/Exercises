package org.milan.test;

import java.util.Scanner;

public class ReverseDemo {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		System.out.println("Please Enter Number of Test Cases : ");
		int testCase = sn.nextInt();
		int[] a = new int[testCase];
		int i = 0;
		while (testCase > 0) {
			a[i] = sn.nextInt();
			System.out.println(a[i]);
			i++;
			testCase--;
		}
		sn.close();
		int[] arr = new ReverseDemo().reverse(a);
		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
		}
	}

	public int[] reverse(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			while (arr[i] > 0) {
				sum = sum * 10 + arr[i] % 10;
				arr[i] /= 10;
			}
			arr[i] = sum;
		}
		return arr;
	}
}
