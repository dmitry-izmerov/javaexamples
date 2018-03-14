package ru.demi.java_examples.java_core.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author demi
 * @date 07.01.17
 */
public class AbsentInheritence {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		// error here
//         List<Number> l = list;
	}
}
