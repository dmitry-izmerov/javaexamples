package ru.demi.java_examples.JAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by demi
 * on 24.06.15.
 */
@XmlType(name = "office")
@XmlRootElement
public class Office {
	@XmlElement(name = "employee")
	@XmlElementWrapper(name = "staff", nillable = true)
	public List<Employee> staff = new ArrayList<>();
}
