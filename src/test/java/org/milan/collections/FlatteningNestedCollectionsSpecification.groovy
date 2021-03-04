package org.milan.collections

import spock.lang.Specification

/**
 * @author Milan Rathod
 */
class FlatteningNestedCollectionsSpecification extends Specification {

    def flatteningNestedCollections = new FlatteningNestedCollections()

    def "flattening nested collection with usingForEach method"() {
        given:
        List<List<String>> nestedList = List.of(
                List.of("one:one"),
                List.of("two:one", "two:two", "two:three"),
                List.of("three:one", "three:two", "three:three", "three:four"))

        when:
        def map = flatteningNestedCollections.usingForEach(nestedList)

        then:
        map != null
        map.size() == 8
    }

    def "flattening nested collection with usingFlatMap method"() {
        given:
        List<List<String>> nestedList = List.of(
                List.of("one:one"),
                List.of("two:one", "two:two", "two:three"),
                List.of("three:one", "three:two", "three:three", "three:four"))

        when:
        def map = flatteningNestedCollections.usingFlatMap(nestedList)

        then:
        map != null
        map.size() == 8
    }
}
