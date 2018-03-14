package ru.demi.java_examples.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by demi
 * on 24.06.15.
 */
public class App04 {
	public static void main(String[] args) throws JAXBException {
		Cat cat = new Cat();
		cat.name = "Some cat";
		cat.age = 2;
		cat.weight = 10;

		Zoo zoo = new Zoo();
		zoo.animals.add(cat);
		zoo.animals.add(cat);

		StringWriter writer = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(Cat.class, Zoo.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(zoo, writer);

		System.out.println(writer.toString());
	}
}

@XmlType(name = "zoo")
@XmlRootElement
class Zoo {
	@XmlElement(name = "lion")
	@XmlElementWrapper(name = "wild-animals", nillable = true)
	public List<Cat> animals = new ArrayList<>();
}

@XmlType(name = "tiger")
class Cat {
	@XmlElement(name = "catname")
	public String name;
	@XmlAttribute(name = "age")
	public int age;
	@XmlAttribute(name = "weight")
	public int weight;
}
