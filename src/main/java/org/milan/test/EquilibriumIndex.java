package org.milan.test;

import java.util.Scanner;

public class EquilibriumIndex {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int testCase = sn.nextInt();
		int[] a = new int[testCase];
		for (int i = 0; i < testCase; i++) {
			a[i] = sn.nextInt();
		}
		int x = new EquilibriumIndex().solution(a);
		System.out.println(x);
	}

	public int solution(int[] a) {
		long sum = 0, count = 0;
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			sum += (long) a[i];
		}
		for (int i = 0; i < a.length; i++) {
			sum -= a[i];
			if (sum == count) {
				result = i;
				break;
			} else {
				count += a[i];
				continue;
			}

		}
		if (result != 0) {
			return result;
		} else {
			return -1;
		}
	}

	int equi(int arr[], int n) {
		if (n == 0)
			return -1;
		long sum = 0;
		int i;
		for (i = 0; i < n; i++)
			sum += (long) arr[i];

		long sum_left = 0;
		for (i = 0; i < n; i++) {
			long sum_right = sum - sum_left - (long) arr[i];
			if (sum_left == sum_right)
				return i;
			sum_left += (long) arr[i];
		}
		return -1;
	}
}
