package org.milan.strings;

public class TextJustification {

	public static void main(String[] args) {
		TextJustification textJustification = new TextJustification();
        String[] words = {"This", "is", "a", "text", "justification","problem","in","tutorial","horizon"};
        int maxLength = 25;
        System.out.println(textJustification.find(words, maxLength, 0));
	}
	
	private String find(String[] words, int maxLength, int index) {
		if (index < words.length) {
			String result = "";
			int remainingLength = maxLength;
			int currentLength = 0;
			while (result.length() < maxLength && index < words.length) {
				String currentWord = words[index];
				int currentWordLength = currentWord.length();
				if (remainingLength >= currentWordLength + 1) {
					if(!result.equals("")) {
						result += "$" + currentWord;
						currentLength = currentWordLength + 1;
					} else {
						result += currentWord;
						currentLength = currentWordLength;	
					}
					remainingLength -= currentLength;
					index++;
				} else if (remainingLength > 0) {
					if (result.contains("$") == false) {
						for (int i = 0; i < remainingLength; i++) {
							result += " ";
						}
					} else {
						String[] arr = result.split("\\$");
						int mod = (remainingLength % (arr.length - 1));
						int splitedSpace = remainingLength / (arr.length -1);
						String spaces = " ";
                        for (int i = 0; i < splitedSpace; i++) {
                            spaces = spaces + " ";
                        }
                        String leftmost = spaces;
                        for (int i = 0; i < mod; i++) {
                            leftmost = leftmost + " ";
                        }
                        result = result.replaceFirst("\\$", leftmost);
                        result = result.replaceAll("\\$", spaces);
					}
				}
			}
			result = result.replaceAll("\\$", " ");
			return result + "\n" + find(words, maxLength, index);
		} else {
			return "";
		}
	}

}
