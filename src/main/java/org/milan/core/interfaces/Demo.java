package org.milan.core.interfaces;

public class Demo {

	public static void main(String[] a) {
		abc a1 = new p1();
		a1.sayHello();
		// a1.sayBye(); // cannot be called

		p1 p = new p1();
		p.sayHello();
		p.sayBye();
	}
}
