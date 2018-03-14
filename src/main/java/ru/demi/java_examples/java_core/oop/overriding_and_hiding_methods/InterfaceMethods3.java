package ru.demi.java_examples.java_core.oop.overriding_and_hiding_methods;

/**
 * Created by demi
 * on 21.06.15.
 * <p>
 * Inherited instance methods from classes can override abstract interface methods.
 */
public class InterfaceMethods3 {
	public static void main(String... args) {
		Mustang myApp = new Mustang();
		System.out.println(myApp.identifyMyself());
	}
}

interface Mammal {
	String identifyMyself();
}

class Horse_ {
	public String identifyMyself() {
		return "I am a horse.";
	}
}

class Mustang extends Horse_ implements Mammal {

}