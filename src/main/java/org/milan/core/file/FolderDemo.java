package org.milan.core.file;

import java.io.*;

public class FolderDemo {
	public static void main(String[] a) {

		File f = new File("C:/Demo");
		System.out.println("Yash");
		Recursion(f);
	}

	static void Recursion(File f) {
		if (f.isDirectory()) {
			String list[] = f.list();
			for (String l : list) {
				File f1 = new File(l);
				if (f1.isDirectory()) {
					Recursion(f1);
				}
			}

		} else {
			System.out.println("File :" + f.getName() + " is in Folder " + f.getParent());
		}
	}

}
