package org.milan.coreJava.ExceptionDemo;

public class P2 {
	public static void main(String[] a) {
		int i = 10, b = 10, k;
		try {
			// open files
			int c = i / b;
			k = 0;
			// close file
		}
		// exception caught by you
		catch (Exception e) {
			System.out.println("Yash:" + e.toString());
		} finally {
			// clean up code
			System.out.println("Finally is always executed whether exception occur or not");
		}
	}

}
