package org.milan.datastructure;

/**
 * @author Milan Rathod
 */
public class Toh {
    private static String SOURCE_PEG = "A";

    private static String SPARE_PEG = "C";

    private static String TARGET_PEG = "B";

    // Time Complexity O(2 power of n)
    public void listSteps(int n, String source, String target, String spare) {
        if (n == 1) {
            System.out.println("Please move from Peg " + source + "\tTo Peg\t"
                    + target);
        } else {
            listSteps(n - 1, source, spare, target);
            listSteps(1, source, target, spare);
            listSteps(n - 1, spare, target, source);
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new Toh().listSteps(3, SOURCE_PEG, TARGET_PEG, SPARE_PEG);

        long endTime = System.currentTimeMillis();

        System.out.println("Done in " + (endTime - startTime) / 1000
                + "\t seconds");
    }
}
