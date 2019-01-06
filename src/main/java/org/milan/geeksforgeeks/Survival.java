package org.milan.geeksforgeeks;

/**
 * Algorithm: Greedy
 * <p>
 * Problem: {@link @https://www.geeksforgeeks.org/survival/}
 *
 * @author Milan Rathod
 */
public class Survival {

    /**
     * @param N Maximum unit of food you can buy each day
     * @param S Number of days you are required to survive
     * @param M Unit of food required each day to survive
     * @return number of days to buy food to survive for S days if not possible return -1
     */
    public int buyFoodDays(int N, int S, int M) {

        if (((N * 6) < (M * 7) && S > 6) || N < M) {
            return -1;
        } else {
            int days = (M * S) / N;

            if (((M * S) % N) != 0)
                days++;
            return days;
        }
    }
}
