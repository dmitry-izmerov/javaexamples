package ru.demi.java_examples.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by demi
 * on 24.06.15.
 */
public class App01 {
	public static void main(String[] args) throws JAXBException {
		Person vasya = new Person();
		vasya.name = "Vasya";
		vasya.age = 24;
		vasya.weight = 80;

		StringWriter sw = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(Person.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(vasya, sw);

		System.out.println(sw.toString());
	}
}