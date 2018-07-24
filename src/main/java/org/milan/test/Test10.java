package org.milan.test;

public class Test10 {
	public static void main(String[] args) {
		int x = new Test10().solution(15, 15);
		System.out.println(x);
		System.out.println(Integer.toBinaryString(23));
		int a[] = new int[] { 1, 0, 0, 1, 1 };
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i] * Math.pow(-2, i);
		}
		System.out.println(sum);

	}

	public int solution(int a, int b) {
		int sum = a + b;
		if (sum % 3 == 0 && sum / 3 < 100000000) {
			return sum / 3;
		} else if (sum % 3 == 0 && sum / 3 >= 100000000) {
			return -2;
		}
		return -1;
	}
}
