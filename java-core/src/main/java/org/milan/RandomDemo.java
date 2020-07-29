package org.milan;

import java.util.Random;

/**
 * Class responsible for generating random numbers using {@link Math#random()} and {@link java.util.Random}
 * <p>
 * NOTE: Random numbers between 0 and 10 example is being used here
 *
 * @author Milan Rathod
 */
public class RandomDemo {

    public static void main(String[] args) {

        // Only generates doubles >= 0.0 and < 1.0
        int randomNumber = (int) (10 * Math.random());

        System.out.println(randomNumber);

        // Support for generating random integers, doubles, floats, longs and booleans
        Random random = new Random();

        System.out.println(random.nextInt(10));
    }
}
