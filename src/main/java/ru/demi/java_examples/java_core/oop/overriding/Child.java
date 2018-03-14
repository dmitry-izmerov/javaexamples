package ru.demi.java_examples.java_core.oop.overriding;

/**
 * Created by demi
 * on 28.11.15.
 */
public class Child extends Parent {
	@Override
	public void print() {
		System.out.println("Child.print()");
	}

	// Error:(16, 20) java: print(java.lang.String...) in ru.demi.java_examples.java_core.oop.overriding.Child cannot override print(java.lang.String...) in ru.demi.java_examples.java_core.oop.overriding.Parent attempting to assign weaker access privileges; was public
    /*@Override
    protected void print(String ...args)
    {
        System.out.println(args);
        System.out.println("Child.print()");
    }*/

	public static void main(String[] args) {
		Parent child = new Child();
		child.print();
		child.print("this", "is", "overriding");

		// If I can assign weaker access modifier to overrided method of parent
		// then I might to pick up runtime error !!! let's see below
		// child.print("hello");
		// if I give third-party client my realization of Parent class
		// and then narrowed access for Parent.print(String[])
		// Client used your class through interface of Parent class!!
		// It will be error in runtime
	}
}
