package org.milan.coreJava.Inheritance;

import java.util.Date;

public class Employee extends Person {

	Date doj;
	boolean married;
	int children;

	// employee class gets four variables from Person class because name variable is
	// not inherited
	public void go() {
		Person p = new Person();
		// p.name="Mango"; // private member not accesible within the class
		p.Contact = "";
		p.address = "";
		p.age = 22;
		p.salary = 5000;
	}
}
