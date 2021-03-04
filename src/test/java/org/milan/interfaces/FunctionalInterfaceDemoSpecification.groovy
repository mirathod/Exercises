package org.milan.interfaces

import spock.lang.Specification

import java.util.function.Function

/**
 * @author Milan Rathod
 */
class FunctionalInterfaceDemoSpecification extends Specification {

    def "Function interface apply method test for class TestA"() {
        given:
        Functional<String, Integer> functionalA = new TestA()

        when:
        Integer result = functionalA.toFunction().apply("test")

        then: "should return length of input parameter"
        result == 4
    }

    def "Function interface apply method test for class TestB"() {
        given:
        Functional<String, Integer> functionalB = new TestB()

        when:
        Integer result = functionalB.toFunction().apply("test")

        then: "should return hashcode of input parameter"
        result == 3556498
    }

    def "Function interface compose method"() {
        given:
        Functional<String, Integer> functionalA = new TestA()
        Function<Integer, String> quote = { s -> "'" + s + "'" }

        when:
        Function<String, String> result = quote.compose(functionalA.toFunction())

        then: "should return hashcode of input parameter"
        result.apply("test") == "'4'"
    }

    def "Function interface andThen method"() {
        given:
        Functional<String, Integer> functionalA = new TestA()
        Function<Integer, String> quote = { s -> "'" + s + "'" }

        when:
        Function<String, String> result = functionalA.toFunction().andThen(quote)

        then: "should return hashcode of input parameter"
        result.apply("test") == "'4'"
    }
}
