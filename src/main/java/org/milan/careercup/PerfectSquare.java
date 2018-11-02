package org.milan.careercup;

/**
 * Perfect Square {@link @https://www.careercup.com/question?id=19638671}
 *
 * @author Milan Rathod
 */
public class PerfectSquare {

    /**
     * Check if number is perfect square or not
     * Time Complexity - O(sqrt(n))
     *
     * @param number input number
     * @param useApi whether to use java api
     * @return true if perfect square otherwise false
     */
    public boolean isPerfectSquare(int number, boolean useApi) {
        if (useApi) {

            double sqrt = Math.sqrt(number);

            // check if double is integer and not an infinite number
            if ((sqrt == Math.floor(sqrt)) && !Double.isInfinite(sqrt)) {
                return true;
            }

            return false;
        } else {

            // Using Arithmetic Progression here i.e. 1,3,5,7,..
            int i = 1;

            while (number > 0) {
                number -= i;
                i += 2;
            }

            return number == 0;
        }
    }
}
