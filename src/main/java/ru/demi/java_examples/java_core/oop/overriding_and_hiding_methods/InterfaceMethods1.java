package ru.demi.java_examples.java_core.oop.overriding_and_hiding_methods;

/**
 * Created by demi
 * on 21.06.15.
 * <p>
 * Instance methods are preferred over interface default methods
 */
public class InterfaceMethods1 {
	public static void main(String... args) {
		Pegasus myApp = new Pegasus();
		System.out.println(myApp.identifyMyself());
	}
}

class Horse {
	public String identifyMyself() {
		return "I am a horse.";
	}
}

interface Flyer {
	default public String identifyMyself() {
		return "I am able to fly.";
	}
}

interface Mythical {
	default public String identifyMyself() {
		return "I am a mythical creature.";
	}
}

class Pegasus extends Horse implements Flyer, Mythical {

}
