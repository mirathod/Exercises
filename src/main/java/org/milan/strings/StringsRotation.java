package org.milan.strings;

public class StringsRotation {

	public static void main(String[] args) {
		String s1 = "sumitjain";
		String s2 = "tjainsumi";
		StringsRotation stringsRotation = new StringsRotation();
		System.out.println("Is '" + s1 + "' and '" + s2 + "' are rotated?? : " + stringsRotation.isRotated(s1, s2));

	}
	
	public boolean isRotated(String s1, String s2) {
		if ((s1 == null || s2 == null) && s1.length() != s2.length()) {
			return false;
		}
		s1 += s1;
		if (s1.contains(s2)) {
			return true;
		}
		return false;
	}

}
