package org.milan.function

import spock.lang.Specification

/**
 * Specification for {@link BiFunctionDemo}
 *
 * @author Milan Rathod
 */
class BiFunctionDemoSpecification extends Specification {

    def "BiFunction test"() {
        given:
        BiFunctionDemo biFunctionDemo = new BiFunctionDemo()

        when:
        int result = biFunctionDemo.find("test", 100,
                { str, value -> str == "test" ? 200 : value })

        then:
        result == 200
    }
}
