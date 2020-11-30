package org.milan.function;

import java.util.function.Supplier;

/**
 * @author Milan Rathod
 */
public class SupplierDemo {

    public double squareLazy(Supplier<Double> lazyValue) {
        return Math.pow(lazyValue.get(), 2);
    }
}
