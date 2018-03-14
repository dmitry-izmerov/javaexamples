package ru.demi.java_examples.java_core.oop;

import java.lang.reflect.Field;

/**
 * Created by demi
 * on 05.06.15.
 */

abstract class Abstract {
	public int prop1;
	public double prop2;

	Abstract() {
		System.out.println("Abstract by default");
	}

	Abstract(int i, double d) {
		prop1 = i;
		prop2 = d;
		System.out.println("Abstract");
	}
}

class Child extends AbstractParent {
	public int childProp;

	public Child(int i) {
		super();
		childProp = i;
		System.out.println("Child");
	}
}


public class AbstractParent {
	public static void main(String[] args) {
		Child c = new Child(30);
		Class<?> cObj = c.getClass();
		for (Field field : cObj.getDeclaredFields()) {
			System.out.println(field.toString());
		}
	}
}
