package org.milan.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Milan Rathod
 */
public class FlatteningNestedCollections {

    public <T> List<T> usingForEach(List<List<T>> nestedCollections) {
        List<T> list = new ArrayList<>();
        nestedCollections.forEach(list::addAll);
        return list;
    }

    public <T> List<T> usingFlatMap(List<List<T>> nestedCollections) {
        return nestedCollections.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
