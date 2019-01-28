package org.milan.core.inner;

/**
 * Method and Member Inner Class Example
 *
 * @author Milan Rathod
 */
public class InnerClass {

    public static void main(String[] args) {

        class Local {
            public void name() {
                System.out.println("Inside Local Inner Class");
            }
        }

        Local local = new Local();
        local.name();

        InnerClass innerClass = new InnerClass();
        InnerClass.Inner inner = innerClass.new Inner();

        inner.name();
    }

    private class Inner {
        public void name() {
            System.out.println("Inside Member Inner Class");
        }
    }
}
