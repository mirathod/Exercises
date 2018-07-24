package org.milan.coreJava.ExceptionDemo;

public class P4 {

	public static void main(String[] a) {
		int i = 10, b = 0;
		int a1[] = new int[5];
		// int k=a1[7];

		try {

			try {
				int c = i / b;
			}

			// catch of inner try
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Inner Catch:" + e.toString());
			}
		}
		// catch of outer try
		catch (ArithmeticException e) {
			System.out.println("Outer Catch:" + e.toString());
		}
	}

}
