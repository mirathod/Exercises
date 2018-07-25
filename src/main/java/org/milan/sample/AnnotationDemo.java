package org.milan.sample;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationDemo {

	
	String value();
}
@Retention(RetentionPolicy.RUNTIME)
@interface Sample2Ann{
	int count();
}
