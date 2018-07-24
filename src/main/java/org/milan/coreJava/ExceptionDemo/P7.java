package org.milan.coreJava.ExceptionDemo;

public class P7 extends P6 {
	public static void main(String[] a) {
		P7 k = new P7();
		// k.sayHello();
		try {
			k.sayHello();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
