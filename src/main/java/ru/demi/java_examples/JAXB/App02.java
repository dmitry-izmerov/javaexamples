package ru.demi.java_examples.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by demi
 * on 24.06.15.
 */
public class App02 {
	public static void main(String[] args) throws JAXBException {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
			"<person>\n" +
			"    <name>Vasya</name>\n" +
			"    <age>24</age>\n" +
			"    <weight>80</weight>\n" +
			"</person>";
		StringReader sr = new StringReader(xml);
		JAXBContext context = JAXBContext.newInstance(Person.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Person person = (Person) unmarshaller.unmarshal(sr);
		System.out.println(person);
	}
}