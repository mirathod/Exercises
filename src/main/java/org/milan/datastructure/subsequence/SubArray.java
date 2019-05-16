package org.milan.datastructure.subsequence;

/**
 * All subarrays of an array
 * say array size is n = possible subarrays are n*(n+1)/2
 *
 * @author Milan Rathod
 */
public class SubArray {

    public void calculate(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(array[k]);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        new SubArray().calculate(new int[]{1, 2, 3, 4}, 4);
    }

}
