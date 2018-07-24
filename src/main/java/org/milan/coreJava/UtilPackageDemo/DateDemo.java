package org.milan.coreJava.UtilPackageDemo;

import java.util.Date;

public class DateDemo {
	public static void main(String[] s) {
		Date d1 = new Date("6/22/1989");
		Date d2 = new Date("5/22/1989");
		Date d3 = new Date("3/15/1991");

		Date d4 = new Date();
		System.out.println(d4.toString());
		System.out.println(d1.after(d3));
		System.out.println(d1.before(d3));
		System.out.println(d2.equals(d3));
		System.out.println(d1.compareTo(d1));
		System.out.println(d1.toString());

	}

}
