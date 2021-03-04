package org.milan.generics;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;

/**
 * Array to Collection Utility Class
 *
 * @author Milan Rathod
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ArrayToCollection {

    public static <T> void fromArrayToCollection(T[] array, Collection<T> collection) {
        Collections.addAll(collection, array);
    }
}
