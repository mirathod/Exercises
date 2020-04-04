package org.milan.util;

import java.util.Collections;
import java.util.List;

/**
 * Utility for {@link java.util.List}
 *
 * @author Milan Rathod
 */
public final class ListUtil {

    /**
     * @param src    source list
     * @param target target list
     * @return true if both lists are equal otherwise false
     */
    public static <T extends Comparable<? super T>> boolean isEqual(List<T> src, List<T> target) {
        if (src == null && target == null) {
            return true;
        }

        if (src == null || target == null || src.size() != target.size()) {
            return false;
        }

        Collections.sort(src);
        Collections.sort(target);

        return src.equals(target);
    }
}
