package org.milan.datastructure.subsequence;

/**
 * Power set of a set
 *
 * @author Milan Rathod
 */
public class PowerSet {

    public static void main(String[] args) {
        new PowerSet().powerSet(new char[]{'a', 'b', 'c'}, 3);
    }

    public void powerSet(char[] set, int setSize) {
        for (int counter = 0; counter < (1 << setSize); counter++) {
            System.out.print("{ ");
            for (int j = 0; j < setSize; j++) {
                if ((counter & (1 << j)) > 0) {
                    System.out.print(set[j] + " ");
                }
            }
            System.out.println("}");
        }
    }
}
