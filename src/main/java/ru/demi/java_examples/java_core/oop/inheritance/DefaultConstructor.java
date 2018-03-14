package ru.demi.java_examples.java_core.oop.inheritance;

/**
 * Created by demi
 * on 11.07.15.
 */
public class DefaultConstructor {
	/**
	 * 1. У класса всегда есть как минимум один конструктор
	 * 2. Если нет конструктора - добавляется по умолчанию
	 * 3. В рамках конструктора подкласса вызывается конструктор суперкласса
	 */
	class Parent /* extends Object */ {
    /*public Parent()
    {
        super();
    }*/
	}

	class Child extends Parent {
    /*public Child()
    {
        super();
    }*/
	}
}