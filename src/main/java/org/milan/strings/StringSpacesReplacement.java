package org.milan.strings;

public class StringSpacesReplacement {

	public static void main(String[] args) {
		String input = "I am Sumit Jain";
		StringSpacesReplacement spacesReplacement = new StringSpacesReplacement();
		System.out.println("New String: " + spacesReplacement.replaceSpaces(input));

	}

	public String replaceSpaces(String input) {
		String[] str = input.split(" ");
		String output = "";
		for (int i = 0; i < str.length - 1; i++) {
			output += str[i] + "%20";
		}
		output += str[str.length - 1];
		return output;
	}

	public String replace(String s) {
		char arr[] = s.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 32)
				sb.append("%20");
			else
				sb.append(arr[i]);

		}

		return sb.toString();
	}

}
