package org.milan.core;

/**
 * 3 ways to convert String to boolean
 *
 * @author Milan Rathod
 */
public class StringToBoolean {

    /**
     * Using Boolean Constructor
     *
     * @param source
     * @return Boolean object
     */
    public Boolean byConstructor(String source) {
        return new Boolean(source);
    }

    /**
     * Using valueOf method
     *
     * @param source
     * @return Boolean object
     */
    public Boolean byValueOf(String source) {
        return Boolean.valueOf(source);
    }

    /**
     * Using parseBoolean method
     *
     * @param source
     * @return boolean primitive type
     */
    public boolean byParseBoolean(String source) {
        return Boolean.parseBoolean(source);
    }
}
