package org.milan.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Milan Rathod
 */
@Hint("hint1")
@Hint("hint2")
public class RepeatableAnnotation {

}

@Retention(RetentionPolicy.RUNTIME)
@interface Hints {
    Hint[] value();
}

@Repeatable(Hints.class)
@Retention(RetentionPolicy.RUNTIME)
@interface Hint {
    String value();
}