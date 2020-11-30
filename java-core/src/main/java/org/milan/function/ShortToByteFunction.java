package org.milan.function;

/**
 * @author Milan Rathod
 */
@FunctionalInterface
public interface ShortToByteFunction {

    byte applyAsByte(short s);
}

class ShortToByte {

    public byte transform(short s, ShortToByteFunction shortToByteFunction) {
        return shortToByteFunction.applyAsByte(s);
    }
}
