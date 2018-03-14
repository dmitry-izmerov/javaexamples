package ru.demi.java_examples.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by demi
 * on 24.06.15.
 */
public class App03 {
	public static void main(String[] args) throws JAXBException {
		Employee employee1 = new Employee();
		employee1.name = "employee1";
		employee1.age = 34;
		employee1.weight = 120;
		Employee employee2 = new Employee();
		employee2.name = "employee2";
		employee2.age = 56;
		employee2.weight = 95;

		Office office = new Office();
		office.staff.add(employee1);
		office.staff.add(employee2);

		StringWriter sw = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(Employee.class, Office.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(office, sw);

		System.out.println(sw.toString());
	}
}
