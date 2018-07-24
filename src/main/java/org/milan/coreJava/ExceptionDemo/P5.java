package org.milan.coreJava.ExceptionDemo;

public class P5 {
	public static void main(String[] a) {
		int i = -10, b = 0;

		try {
			if (i < 0) {
				throw new ArithmeticException("Explicitly Thrown");
			}
		}

		catch (ArithmeticException e) {
			System.out.println("Subclass First:" + e.toString());
		}
	}

}
