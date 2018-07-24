package org.milan.coreJava.RunTimeDemo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class P1 {
	public static void main(String[] s) {
		Runtime r = Runtime.getRuntime();

		try {

			r.exec("Notepad");
		} catch (IOException ex) {
			System.out.println(ex.toString());
		}
	}

}
