package org.milan.datastructure.array;

/**
 * Problem: Delete Duplicates
 *
 * @author Milan Rathod
 */
public class DeleteDuplicates {

    public Integer[] returnUniqueNumbers(Integer[] original,
                                         Integer[] uniqueNumbers) {
        int k = 0;

        for (int j = original.length - 1; j >= 0; j--) {
            boolean present = false;
            for (Integer u : uniqueNumbers) {
                if (u != null) {
                    if (u.equals(original[j])) {
                        present = true;
                        break;
                    }
                }
            }
            if (!present) {
                uniqueNumbers[k] = original[j];
                k++;
            }
        }
        return uniqueNumbers;
    }
}