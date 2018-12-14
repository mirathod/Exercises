package org.milan.hackerearth;

/**
 * {@link @https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/roys-life-cycle-44/}
 *
 * @author Milan Rathod
 */
public class RoysLifeCycle {

    private int longestCodingStreakAcross = 0;

    private int codingStreakAcross = 0;

    public int getLongestCodingStreakPerDay(String input) {
        char[] arr = input.toCharArray();

        int tempDayCount = 0;

        int finalDayCount = 0;

        int tempContinousStreak = codingStreakAcross;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 'C') {
                tempDayCount++;
                tempContinousStreak++;
            } else {
                if (tempDayCount > finalDayCount) {
                    finalDayCount = tempDayCount;
                }
                tempDayCount = 0;

                if (tempContinousStreak > longestCodingStreakAcross) {
                    longestCodingStreakAcross = tempContinousStreak;
                }
                tempContinousStreak = 0;
            }
        }

        codingStreakAcross = tempContinousStreak;

        if (tempDayCount > finalDayCount) {
            finalDayCount = tempDayCount;
        }

        if (codingStreakAcross > longestCodingStreakAcross) {
            longestCodingStreakAcross = codingStreakAcross;
        }

        return finalDayCount;
    }

    public int getLongestCodingStreakAcross() {
        return longestCodingStreakAcross;
    }
}
