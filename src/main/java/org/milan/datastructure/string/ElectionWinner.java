package org.milan.datastructure.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: {@link @https://www.geeksforgeeks.org/find-winner-election-votes-represented-candidate-names/}
 * <p>
 * Time and Space complexity: O(n)
 *
 * @author Milan Rathod
 */
public class ElectionWinner {

    /**
     * Finding winner from the given array of votes using hash map
     *
     * @param votes array of strings representing votes
     * @return winner
     */
    public String find(String[] votes) {

        // Map used for storing candidate and number of votes mapping
        Map<String, Integer> mapping = new HashMap<>();

        for (String vote : votes) {
            if (mapping.containsKey(vote)) {
                mapping.put(vote, mapping.get(vote) + 1);
            } else {
                mapping.put(vote, 1);
            }
        }

        // Traverse through the map to find the winner
        int maxValue = 0;
        String winner = null;

        for (Map.Entry<String, Integer> entry : mapping.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                winner = entry.getKey();
            } else if (entry.getValue() == maxValue && (entry.getKey()).compareTo(winner) < 0) {
                // In case of tie, pick lexicographically smaller one
                winner = entry.getKey();
            }
        }

        return winner;
    }
}
