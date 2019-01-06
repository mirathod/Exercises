package org.milan.hackerearth;

/**
 * Problem Statement {@link @https://www.hackerearth.com/practice/data-structures/advanced-data-structures/fenwick-binary-indexed-trees/practice-problems/algorithm/goris-crush/}
 *
 * @author Milan Rathod
 */
public class GoriCrush {

    public String determineFortune(long[] inputArray, long[] queries, int K) {
        if (queries[0] == 0) {
            int index = (int) (queries[1] - 1);
            inputArray[index] = queries[2];
        } else {
            long a = queries[1];
            long b = queries[2];
            long c = queries[3];
            long d = queries[4];

            long match = 0;

            for (long element : inputArray) {
                if ((element >= a && element <= b) && (element >= c && element <= d)) {
                    match++;
                }
            }

            if (match >= K) {
                return "Propose";
            } else {
                return "Do not propose";
            }
        }
        return "";
    }

}
