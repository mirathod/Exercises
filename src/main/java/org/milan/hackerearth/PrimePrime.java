package org.milan.hackerearth;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * {@link @https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/micro-and-prime-prime-1/}
 *
 * @author Milan Rathod
 */
public class PrimePrime {

    private Set<Long> primes = new TreeSet<>();

    private boolean[] prime = new boolean[(int) 1e6 + 10];

    public long calculatePrimeCount(long left, long right) {

        Set<Long> temp = new TreeSet<>();

        long count = 0;

        for (long i = 1; i < left; i++) {
            if (primes.contains(i)) {
                temp.add(i);
            } else if (isPrime(i)) {
                primes.add(i);
                temp.add(i);
            }
        }

        for (long i = left; i <= right; i++) {
            if (primes.contains(i)) {
                temp.add(i);
            } else if (isPrime(i)) {
                primes.add(i);
                temp.add(i);
            }

            long size = temp.size();
            if (primes.contains(size) || isPrime(size)) {
                count++;
            }

        }

        return count;

    }

    private boolean isPrime(long number) {

        if (number == 1 || number == 0) return false;

        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    private void prime() {
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= (int) 1e6; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= (int) 1e6; j += i) {
                    prime[j] = false;
                }
            }
        }

    }

    public int getPrimeCount(int left, int right) {
        prime();

        int[] ans = new int[(int) 1e6 + 10];

        int n_prime = 0;
        int a = 0;

        for (int i = 1; i <= (int) 1e6; i++) {
            if (prime[i])
                n_prime++;

            if (prime[n_prime])
                a++;

            ans[i] = a;
        }

        return ans[Math.max(left, right)] - ans[Math.min(left, right) - 1];
    }
}
