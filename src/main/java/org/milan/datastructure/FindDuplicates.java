package org.milan.datastructure;

/**
 * Problem: Find Duplicates
 *
 * @author Milan Rathod
 */
public class FindDuplicates {

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3, 0, 4, 2, 4, 0};
        new FindDuplicates().duplicate(inputArray);
    }

    private void duplicate(int[] a) {

        for (int i = 0; i < a.length; i++) {
            if (a[Math.abs(a[i])] > 0) {
                a[Math.abs(a[i])] = -a[Math.abs(a[i])];
            } else if (a[Math.abs(a[i])] == 0) {
                continue;
            } else {
                System.out.print(Math.abs(a[i]) + " ");
            }

        }

    }
}
