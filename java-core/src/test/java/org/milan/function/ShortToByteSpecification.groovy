package org.milan.function

import spock.lang.Specification

/**
 * Specification for {@link ShortToByte}
 *
 * @author Milan Rathod
 */
class ShortToByteSpecification extends Specification {

    def "shortToByte function test"() {
        given:
        ShortToByte shortToByte = new ShortToByte()

        when:
        byte result = shortToByte.transform((short) 1, { s -> (byte) (s * 2) })

        then:
        result == (byte) 2
    }
}
