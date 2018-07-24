package org.milan.coreJava.ExceptionDemo;

import java.io.File;
import java.io.IOException;

public class Checked {

	public static void main(String[] a) throws IOException {
		int i = 10, j = 0;
		int k = i / j; // unchecked exception

		String s = null;

		s.charAt(0); // unchecked exception

		File f = new File("f:/out");

		f.createNewFile(); // checked exception

	}
}
