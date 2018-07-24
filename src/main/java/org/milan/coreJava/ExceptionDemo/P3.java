package org.milan.coreJava.ExceptionDemo;

public class P3 {
	public static void main(String[] a) {
		int i = 10, b = 0;

		try {
			int c = i / b;
		} catch (ArithmeticException e) {
			System.out.println("Subclass First:" + e.toString());
		}

		catch (Exception e) {
			System.out.println(e.toString());
		}

		finally {
			System.out.println("Finally is always executed whether exception occur or not");
		}
	}

}