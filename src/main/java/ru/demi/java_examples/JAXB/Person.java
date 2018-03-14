package ru.demi.java_examples.JAXB;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by demi
 * on 24.06.15.
 */
@XmlType(name = "person")
@XmlRootElement
class Person {
	public String name;
	public int age;
	public int weight;

	@Override
	public String toString() {
		return "Person{" +
			"name='" + name + '\'' +
			", age=" + age +
			", weight=" + weight +
			'}';
	}
}