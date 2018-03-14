package ru.demi.java_examples.java_8.annotaions;

/**
 * Created by demi
 * on 06.09.15.
 */
public class OldVersion {

}

@interface Annotation {
	String value();
}

@interface Annotations {
	Annotation[] value();
}

@Annotation("1")
@Annotations({@Annotation("1"), @Annotation("2")})
class Some {

}