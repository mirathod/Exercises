package org.milan.coreJava.StaticDemo;

public class Hello {

	public static void main(String[] a) {
		ABC a1 = new ABC();
		ABC a2 = new ABC();

		System.out.println("No of Objects Created :" + ABC.count);
		ABC.sayHello(); // proper way

		a1.sayHello(); // no error but aa not proper way to call static method
	}

}
