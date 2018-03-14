package ru.demi.java_examples.java_8.lambda;

/**
 * Created by demi
 * on 03.09.15.
 */
@FunctionalInterface
public interface MyFunctional02 {
	void method();

	default void method02() {
		System.out.println("MyFunctional02.method02()");
	}
}
