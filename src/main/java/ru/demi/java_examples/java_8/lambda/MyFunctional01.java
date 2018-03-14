package ru.demi.java_examples.java_8.lambda;

/**
 * Created by demi
 * on 03.09.15.
 */
@FunctionalInterface
public interface MyFunctional01 {
	void method();
	// Error:(7, 1) java: Unexpected @FunctionalInterface annotation
	//  ru.demi.java_examples.java_8.MyFunctional01 is not a functional interface
	//  multiple non-overriding abstract methods found in interface ru.demi.java_examples.java_8.MyFunctional01
	// void method02();
}
