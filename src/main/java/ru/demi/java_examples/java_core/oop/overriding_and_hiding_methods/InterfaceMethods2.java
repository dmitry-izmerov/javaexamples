package ru.demi.java_examples.java_core.oop.overriding_and_hiding_methods;

/**
 * Created by demi
 * on 21.06.15.
 * <p>
 * Methods that are already overridden by other candidates are ignored.
 * This circumstance can arise when supertypes share a common ancestor.
 */
public class InterfaceMethods2 {
	public static void main(String... args) {
		Dragon myApp = new Dragon();
		System.out.println(myApp.identifyMyself());
	}
}

interface Animal {
	default public String identifyMyself() {
		return "I am an animal.";
	}
}

interface EggLayer extends Animal {
	default public String identifyMyself() {
		return "I am able to lay eggs.";
	}
}

interface FireBreather extends Animal {
}

class Dragon implements EggLayer, FireBreather {

}