package ru.demi.java_examples.java_8.annotaions;

import java.lang.annotation.Repeatable;

/**
 * Created by demi
 * on 06.09.15.
 */
public class NewVersion {
}

@Repeatable(AnnotationsRepeatable.class)
@interface AnnotationRepeatable {
	String value();
}

@interface AnnotationsRepeatable {
	AnnotationRepeatable[] value();
}

@AnnotationRepeatable("1")
@AnnotationRepeatable("2")
class UsingRepeatable {
}