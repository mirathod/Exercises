package org.milan.coreJava.Constructors;

class Dog {
	int tail;

	private Dog(int tail) {
		this.tail = tail;
	}

	public void go() {
		Dog d = new Dog(10);
	}
	// public Dog(){

	// }
}

class Person {
	int height;
	int weight;

	Person(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}

	void go() {

	}

}

class Customer extends Person {
	String name;
	int height;

	public Customer(int height, int weight, String name) {
		super(height, weight);
		this.name = name;
	}

	public Customer(int height, int weight) {
		super(height, weight);
		this.name = "Yash";
	}

	void go() {
		super.go();
	}

	void go(int i) {

	}

	void sayHello(int height) {
		super.height = height;
		this.height = height - 1;
	}
}

public class CustomerDemo {
	public static void main(String[] a) {
		Customer c = new Customer(150, 40, "Yash");
		Customer c1 = new Customer(150, 40);
		// Dog d=new Dog(10);
		c.sayHello(40);

		System.out.println(c.height);
	}
}
