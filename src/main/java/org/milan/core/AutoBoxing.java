package org.milan.core;

/**
 * Strange Behavior of Integer Objects when comparison using == during autoboxing
 *
 * @author Milan Rathod
 */
public class AutoBoxing {

    public boolean comparisonUsingOperator(Integer source, Integer target) {
        return source == target;
    }

    public boolean comparisonUsingMethod(Integer source, Integer target) {
        return source.equals(target);
    }

}
