package org.milan.Java8Demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SampleAnn {

	
	String value();
}
@Retention(RetentionPolicy.RUNTIME)
@interface Sample2Ann{
	int count();
}
