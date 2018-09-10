package org.milan.datastructure;
public class DeleteDuplicates {
public Integer[] returnUniqueNumbers(Integer[] original,
        Integer[] uniqueNumbers) {
    int k = 0;  

    for (int j =  original.length - 1; j >= 0; j--) {
        boolean present = false;
        for (Integer u : uniqueNumbers) {
            if (u != null){
            if(u.equals(original[j])) {
                present = true;
                break;
            }}
        }
        if (present == false) {
            uniqueNumbers[k] = original[j];
            k++;
        }
    }
    return uniqueNumbers;
}

public static void main(String args[]) {
    DeleteDuplicates removeDup = new DeleteDuplicates();
    Integer[] original = { 11, 2,4,2,3 };
    Integer[] finalValue = new Integer[original.length + 1];

    // method to return unique values
    Integer[] unique = removeDup.returnUniqueNumbers(original, finalValue);

    // iterate to return unique values
    System.out.print("unique value :");
    for (Integer u : unique) {
        if (u != null) {
            System.out.print(" " + u);
        }
    }
}}