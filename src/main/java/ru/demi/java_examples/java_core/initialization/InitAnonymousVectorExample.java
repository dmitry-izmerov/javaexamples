package ru.demi.java_examples.java_core.initialization;

import java.util.ArrayList;
import java.util.Vector;

import static java.lang.Math.*;

/**
 * @author demi
 * @date 11.01.17
 */
public class InitAnonymousVectorExample {
	static Vector<Integer> v = new Vector<>();

	{
		v.add(7);
	}

	static {
		v.add(5);
	}

	static {
		v = new Vector<Integer>() {
			{
				add(8);
				addAll(v);
				addAll(this);
			}
		};
	}

	public static void main(String[] args) {
		System.out.println(new InitAnonymousVectorExample().v);

		new ArrayList() {
			{
				System.out.println("in init block");
			}
		};
	}
}
