package org.milan.hackerearth;

import java.util.Arrays;

/**
 * {@link @https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/problem-16-b45b3a5d/}
 *
 * @author Milan Rathod
 */
class DetermineWinner {

    public String getWinner(long[] problems, long[] decreaseScores, long[] flash, long[] cisco) {

        long flashTotalScore = 0;
        long ciscoTotalScore = 0;

        for (int j = 0; j < 4; j++) {

            // Temporary variable to store score calculation
            long temp;

            long problemScore = problems[j];

            long decreaseScore = decreaseScores[j];

            long flashScore = flash[j];

            long ciscoScore = cisco[j];

            temp = problemScore - flashScore * decreaseScore;

            if (temp > problemScore / 2)
                flashTotalScore = flashTotalScore + temp;
            else
                flashTotalScore = flashTotalScore + problemScore / 2;


            temp = problemScore - ciscoScore * decreaseScore;

            if (temp > problemScore / 2)
                ciscoTotalScore = ciscoTotalScore + temp;
            else
                ciscoTotalScore = ciscoTotalScore + problemScore / 2;
        }

        // Condition 1: flash & cisco's score are equal
        if (flashTotalScore == ciscoTotalScore) {

            Arrays.sort(flash);
            Arrays.sort(cisco);
            long z1 = flash[flash.length - 1];
            long z2 = cisco[cisco.length - 1];
            if (z1 == z2)
                return "Tie";
            else if (z1 < z2)
                return "Flash";
            else
                return "Cisco";

        } else if (flashTotalScore > ciscoTotalScore)
            return "Flash";
        else
            return "Cisco";

    }
}