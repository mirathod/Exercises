package org.milan.strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author rathom1
 *
 */
public class StringsPermutation {

	public static void main(String[] args) {
		StringsPermutation stringsPermutation = new StringsPermutation();
		String s1 = "abc";
		String s2 = "ccb";
		if (stringsPermutation.isPermutation(s1, s2)) {
			System.out.println(s1 + " and " + s2 + " are permuted.");
		} else {
			System.out.println(s1 + " and " + s2 + " are not permuted.");
		}

	}

	public boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		HashMap<Character, Integer> hashMap = new HashMap<>();

		// put first string's characters and number of count as key-value pair in hash
		// map.
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.get(c) + 1);
			} else {
				hashMap.put(c, 1);
			}
		}

		// get second string's characters and number of count as key-value pair in hash
		// map.
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (hashMap.containsKey(c)) {
				int value = hashMap.get(c);
				if (value == 0) {
					return false;
				}
				hashMap.put(c, value - 1);
			} else {
				return false;
			}
		}
		
		Set<Character> keys = hashMap.keySet();
		
		Iterator<Character> iterator = keys.iterator();
		
		while (iterator.hasNext()) {
			char c = iterator.next();
			if (hashMap.get(c) != 0) {
				return false;
			}
		}
		return true;
	}

}
