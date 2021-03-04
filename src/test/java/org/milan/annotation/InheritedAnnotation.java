package org.milan.annotation;

import java.lang.annotation.*;

/**
 * @author Milan Rathod
 */
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface InheritedAnnotation {

}

@InheritedAnnotation
class BaseClass {

}

class DerivedClass extends BaseClass {

}

class NotDerivedClass {

}
