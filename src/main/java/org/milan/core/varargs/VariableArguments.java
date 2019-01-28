package org.milan.core.varargs;

/**
 * Variable Arguments Demo
 *
 * @author Milan Rathod
 */
public class VariableArguments {

    public int sum(int... v) {
        int sum = 0;
        for (int i : v) {
            sum += i;
        }
        return (sum);
    }
}
