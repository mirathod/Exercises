package org.milan.function

import com.google.common.util.concurrent.Uninterruptibles
import spock.lang.Specification

import java.util.concurrent.TimeUnit
import java.util.function.Supplier

/**
 * Specification for {@link SupplierDemo}
 *
 * @author Milan Rathod
 */
class SupplierDemoSpecification extends Specification {

    def "Supplier demo"() {
        given:
        SupplierDemo supplierDemo = new SupplierDemo()

        when:
        Supplier<Double> supplier = { ->
            Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS)
            return 9d
        }
        double result = supplierDemo.squareLazy(supplier)

        then:
        result == 81.0d
    }
}
