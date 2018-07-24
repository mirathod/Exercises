package org.milan.coreJava.ExceptionDemo;

class MyException extends Exception {
	@Override
	public String toString() {
		return "MyException: Divide by  zero";
	}
}

public class P8 {
	public static void main(String[] a) {
		int i = 10, b = 0;
		try {
			try {

				int c = i / b;
			} catch (Exception e) {
				throw new MyException();
			}
		} catch (MyException e) {
			System.out.println(e.toString());
		}
	}

}
