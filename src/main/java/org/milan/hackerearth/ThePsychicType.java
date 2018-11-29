package org.milan.hackerearth;

/**
 * {@link @https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/the-psychic-type/}
 *
 * @author Milan Rathod
 */
public class ThePsychicType {

    public boolean isReachable(int[] inputArray, int source, int destination) {

        if (source == destination) {
            return true;
        }

        int initialSource = source;

        int length = inputArray.length;

        int count = 0;

        while (true) {

            source = inputArray[source - 1];

            if (source == initialSource || count > length) {
                return false;
            }

            if (source == destination) {
                return true;
            }
            count++;
        }
    }
}
