package ru.demi.java_examples.java_core.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Created by demi
 * on 02.01.16.
 */
public class UsingRepeatableAnnotation {
	@Repeatable(RepeatableAnnotations.class)
	@Retention(RetentionPolicy.RUNTIME)
	@interface RepeatableAnnotation {
		String value() default "";
	}

	@Retention(RetentionPolicy.RUNTIME)
	@interface RepeatableAnnotations {
		RepeatableAnnotation[] value();
	}

	/**
	 * Equals to next
	 *
	 * @RepeatableAnnotations({
	 * @RepeatableAnnotation("some"),
	 * @RepeatableAnnotation("value") })
	 */
	@RepeatableAnnotation("some")
	@RepeatableAnnotation("value")
	public static void test() {
		System.out.println("UsingRepeatableAnnotation.test()");
	}

	public static void main(String[] args) throws NoSuchMethodException {
		Class<UsingRepeatableAnnotation> clazz = UsingRepeatableAnnotation.class;
		Method method = clazz.getDeclaredMethod("test");
		RepeatableAnnotations annotation = method.getAnnotation(RepeatableAnnotations.class);
		for (RepeatableAnnotation repeatableAnnotation : annotation.value()) {
			System.out.println(repeatableAnnotation.value());
		}
	}
}
