package org.milan.hackerearth;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link @https://www.hackerearth.com/practice/algorithms/dynamic-programming/state-space-reduction/practice-problems/algorithm/bytelandian-gold-coins/}
 *
 * @author Milan Rathod
 */
public class BytelandianGoldCoins {

    private final Map<Long, Long> values = new HashMap<>();

    public BytelandianGoldCoins() {
        values.put(0L, 0L);
        values.put(1L, 1L);
        values.put(2L, 2L);
        values.put(12L, 13L);
    }

    public long replaceCoins(long coin) {
        return values.containsKey(coin) ? values.get(coin) :
                Math.max(coin, replaceCoins(coin >> 2) + replaceCoins(coin / 3) + replaceCoins(coin >> 1));
    }
}
