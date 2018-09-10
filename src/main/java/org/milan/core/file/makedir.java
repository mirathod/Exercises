package org.milan.core.file;

import java.io.File;
import java.util.StringTokenizer;

public class makedir {
	static String asd = "/r/t/y/u/w";

	public static void main(String arg[]) {

		String dir = "C:/f";
		File w = new File(dir);
		w.mkdir();

		StringTokenizer st = new StringTokenizer(asd, "/");
		while (st.hasMoreTokens()) {
			dir = dir + "/" + st.nextToken();
			File w2 = new File(dir);
			w2.mkdir();
		}
		File f = new File("C:/q/w/e/r/t/y");
		f.mkdirs();
	}
}
