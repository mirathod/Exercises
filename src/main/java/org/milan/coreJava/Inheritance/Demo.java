package org.milan.coreJava.Inheritance;

public class Demo {

	public static void main(String[] a) {
		Customer c = new Customer();
		Person p = new Person();
		int age = p.age;
		c.emailid = "wearebusy@aspire.com"; // default members are accesible within classes in same package
		// Demo class and Customer class are in same package emailid is default member
		// p.name="ttt";
		// protected member can be accesed by any class in same package and by subclass
		// in other package
		// c.name="LD College"; // name is private member of Person so cannot be
		// inherited
		System.out.println(age);
	}
}
