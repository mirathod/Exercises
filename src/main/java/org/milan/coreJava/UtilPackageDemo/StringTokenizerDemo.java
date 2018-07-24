package org.milan.coreJava.UtilPackageDemo;

import java.util.StringTokenizer;

public class StringTokenizerDemo {
	public static void main(String[] s) {

		String str = "name=Yash;surname=Raithatha;College=LD";
		StringTokenizer d = new StringTokenizer(str, "=;");
		System.out.println(d.countTokens());

		while (d.hasMoreTokens()) {
			System.out.print(d.nextToken() + ":");

			System.out.println(d.nextToken());
		}
	}

}
