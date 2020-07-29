package org.milan;

import java.util.Properties;

/**
 * Properties Class Example
 *
 * @author Milan Rathod
 */
public class PropertiesDemo {

    public static void main(String[] a) {
        Properties properties;
        try {
            properties = System.getProperties();
            System.out.println(properties.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
