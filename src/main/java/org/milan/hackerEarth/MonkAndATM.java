package org.milan.hackerEarth;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Monk and ATM - Number Theory
 * 
 * @author rathom1
 *
 */
public class MonkAndATM {

	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);
		int T = s.nextInt();

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < T; i++) {
			int N = s.nextInt();
			list.add(N);
		}
		for (Integer N : list) {
			int output = new MonkAndATM().checkPin(N);
			System.out.println(output);
		}

	}

	public int checkPin(int n) {
		int max = 0, pin = 1;
		for (int i = pin; i <= n / 2; i++) {
			int temp = returnCoin(n, i);
			if (max < temp) {
				max = temp;
			}
		}
		return max;
	}

	public int returnCoin(int N, int PIN) {
		if (N % PIN != 0)
			return 0;

		int M = N / PIN;
		int value = 0;
		for (int i = 1; i <= M; i++) {
			BigInteger b1 = new BigInteger(String.valueOf(i));
			BigInteger b2 = new BigInteger(String.valueOf(M));
			if (b1.gcd(b2).equals(b1)) {
				value++;
			}
		}
		if (isPowerof2(value))
			return value;
		else
			return 0;

	}

	public boolean isPowerof2(int value) {
		if ((value & -value) == value)
			return true;
		return false;
	}

}
