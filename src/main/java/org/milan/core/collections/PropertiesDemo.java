package org.milan.core.collections;

import java.util.Properties;

/**
 * @author Milan Rathod
 */
public class PropertiesDemo {
    public static void main(String[] a) {
        try {
            Properties p = new Properties();
            p = System.getProperties();
            System.out.println(p.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
