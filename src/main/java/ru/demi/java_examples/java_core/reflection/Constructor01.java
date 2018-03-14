package ru.demi.java_examples.java_core.reflection;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by demi
 * on 24.07.15.
 */
public class Constructor01 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class<?> clazz = Class.forName("java.awt.Point");
		//!!! error
		// Constructor<?> constructor = clazz.getConstructor(Integer.class, Integer.class);
		Constructor<?> constructor = clazz.getConstructor(int.class, int.class);

		Point p = (Point) constructor.newInstance(1, 2);
		System.out.println(p);

		Class intcl = int.class;
		System.out.println(intcl);
	}
}
