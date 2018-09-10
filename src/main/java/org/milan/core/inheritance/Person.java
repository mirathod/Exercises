package org.milan.core.inheritance;

public class Person {

	private String name; // private members are not inherited
	public String address;
	String Contact;
	protected int age;
	int salary;

	public Person() {
		this.name = "L.D College"; // private members are accesible only within the class

		this.address = "L.D.Hostel";

		this.salary = 5000;

		this.age = 22;

		this.Contact = "9904755011";

	}

	public void goes() {
		name = "Yash";
		address = "";
	}

}
