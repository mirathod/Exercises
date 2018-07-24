package org.milan.coreJava.FileDemo;

import java.io.File;

import java.io.FilenameFilter;

public class DirectoryDemo {
	public static void main(String[] a) {
		File f = new File("C:/Demo");

		if (f.exists()) {
			String[] filelist = f.list();
			for (String file : filelist) {
				System.out.println(file);
			}
		}

		File f2 = new File("C:/Demo/D1");
		MyExt fl = new MyExt("txt");
		String[] list2 = f2.list(fl);

		for (String file : list2) {
			System.out.println(file);
		}
	}

}

class MyExt implements FilenameFilter {

	String ext;

	public MyExt(String ext) {
		this.ext = ext;
	}

	public boolean accept(File dir, String name) {
		return name.endsWith(this.ext);
	}

}
