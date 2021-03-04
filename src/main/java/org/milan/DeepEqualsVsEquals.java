package org.milan;

import java.util.Arrays;

/**
 * Use case of Deep Equals and Equals method of Arrays class
 * <p>
 * for non-nested array both are same
 * prefer equals over deepEquals for non-nested array comparison
 * <p>
 * for nested array, deepEquals perform deep comparison i.e. for nested element inside array it will again perform nested comparison
 * where as equals method perform non-nested array and depend on object reference of nested objects to check if both are equals or not.
 * <p>
 * for nested array prefer deepEquals over equals
 *
 * @author Milan Rathod
 */
public class DeepEqualsVsEquals {

    public static void main(String[] args) {

        int[] i1 = new int[]{1, 2, 3, 4};
        int[] i2 = new int[]{1, 2, 3, 4};

        boolean result = Arrays.equals(i1, i2);

        System.out.println("Integer array comparison: " + result);

        Object[] o1 = new Object[]{"one", new String[]{"two"}};
        Object[] o2 = new Object[]{"one", new String[]{"two"}};

        result = Arrays.equals(o1, o2);

        System.out.println("Object array comparison by equals: " + result);

        result = Arrays.deepEquals(o1, o2);

        System.out.println("Object array comparison by deepEquals: " + result);
    }
}
