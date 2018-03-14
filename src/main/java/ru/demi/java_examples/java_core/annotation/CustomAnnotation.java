package ru.demi.java_examples.java_core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * Created by demi
 * on 20.06.15.
 */
public class CustomAnnotation {

	@Retention(RetentionPolicy.RUNTIME)
	@Target(value = ElementType.TYPE)
	@Documented
	@Inherited
	@Repeatable(ClassInfos.class)
	@interface ClassInfo {
		String author();

		String date();

		double version() default 1.0;

		String description();
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(value = ElementType.TYPE)
	@Documented
	@Inherited
	@interface ClassInfos {
		ClassInfo[] value();
	}

	@ClassInfo(
		author = "demi",
		date = "20/06/15",
		version = 1.1,
		description = "some description"
	)
	@ClassInfo(
		author = "demi",
		date = "11/02/17",
		version = 1.2,
		description = "modified this example"
	)
	class SomeClass {
		// something do...
	}

	public static void main(String[] args) {
		Class<SomeClass> clazz = SomeClass.class;
		if (clazz.isAnnotationPresent(ClassInfos.class)) {
			ClassInfos classInfos = clazz.getAnnotation(ClassInfos.class);
			Arrays.stream(classInfos.value()).forEach(classInfo -> {
				System.out.printf("author=%s, date=%s, version=%f, desc=%s", classInfo.author(), classInfo.date(), classInfo.version(), classInfo.description());
				System.out.println();
			});
		}
	}
}
