package ru.demi.java_examples.java_core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Created by demi
 * on 01.01.16.
 */
public class UsingLocalVariableAnnotation {
	@Target(ElementType.LOCAL_VARIABLE)
	@interface UsingLocalVariable {
		String appeding() default "";
	}

	// @see https://docs.oracle.com/javase/specs/jls/se6/html/interfaces.html#9.6.1.2
	static void print() {
		@UsingLocalVariable(appeding = " in end")
		String toPrinting = "some";
	}

	public static void main(String[] args) throws NoSuchMethodException {
		Class<UsingLocalVariable> clazz = UsingLocalVariable.class;
		Method method = clazz.getDeclaredMethod("print");

		// An annotation on a local variable declaration is never retained in the binary representation.
	}
}
