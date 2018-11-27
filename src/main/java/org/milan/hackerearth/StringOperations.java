package org.milan.hackerearth;

/**
 * {@link @https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/string-operations-1-cd102cb6/}
 *
 * @author Milan Rathod
 */
public class StringOperations {

    public void replaceOperation(StringBuilder stringBuilder, int index, char ch) {
        stringBuilder.setCharAt(index, ch);
    }

    public void reverseOperation(StringBuilder stringBuilder, int startIndex, int endIndex) {
        StringBuilder tempString = new StringBuilder(stringBuilder.substring(startIndex, endIndex));
        stringBuilder.replace(startIndex, endIndex, tempString.reverse().toString());
    }
}
