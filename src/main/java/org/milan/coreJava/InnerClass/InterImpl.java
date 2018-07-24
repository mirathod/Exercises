package org.milan.coreJava.InnerClass;

interface Cookable {
	public void cook();
}

abstract class Person {
	abstract void Hello();
}

public class InterImpl {

	public static void main(String[] a) {
		Cookable c = new Cookable() {
			// overriding cook method
			public void cook() {
				System.out.println("anonymous cookable implementer");
				cook2();
			}

			public void cook2() {

			}
		};
		// now c referes to object of class implementing Cookable interface
		c.cook();
		Person p = new Person() {
			// overriding Hello method
			void Hello() {
				System.out.println("Person Abstract Class");
			}
		};
		// now p referes to object of class extending Person class
		p.Hello();
	}

}
