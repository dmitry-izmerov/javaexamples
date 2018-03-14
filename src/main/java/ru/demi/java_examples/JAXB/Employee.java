package ru.demi.java_examples.JAXB;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by demi
 * on 24.06.15.
 */
@XmlRootElement
public class Employee {
	public String name;
	public int age;
	//@XmlAttribute(name = "weight")
	public int weight;

	@Override
	public String toString() {
		return "Employee{" +
			"name='" + name + '\'' +
			", age=" + age +
			", weight=" + weight +
			'}';
	}
}
