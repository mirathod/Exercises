package org.milan.core.generics;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;

/**
 * Add Description
 *
 * @author Milan Rathod
 * @since
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ArrayToCollection {

    public static <T> void fromArrayToCollection(T[] array, Collection<T> collection) {
        Collections.addAll(collection, array);
    }
}
