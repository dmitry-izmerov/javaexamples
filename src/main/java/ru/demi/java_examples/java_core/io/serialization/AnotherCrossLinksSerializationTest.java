package ru.demi.java_examples.java_core.io.serialization;

import java.io.*;

/**
 * Created by demi
 * on 16.05.15.
 */
public class AnotherCrossLinksSerializationTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		B b = new B();
		C c = new C();
		b.setC(c);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(b);
		oos.writeObject(c);
		oos.writeObject(c);
		oos.writeObject(c);
		oos.flush();
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
		B b1 = (B) ois.readObject();
		C c1 = (C) ois.readObject();
		C c2 = (C) ois.readObject();
		C c3 = (C) ois.readObject();
		System.out.println("b1.getC()==c1: " + (b1.getC() == c1));
		System.out.println("c1==c2: " + (c1 == c2));
		System.out.println("c1==c3: " + (c1 == c3));

		/**
		 * Как видим, все четыре десериализованных объекта на самом деле представляют собой один объект – ссылки на него равны. Ровно как это и было до сериализации.

		 Еще один интересный момент – что будет, если одновременно реализовать у класса Externalizable и Serializable? Как в том вопросе – слон против кита – кто кого поборет?

		 Поборет Externalizable. Механизм сериализации сначала проверяет его наличие, а уж потом – наличие Serializable Так что если класс B, реализующий Serializable, наследуется от класса A, реализующего Externalizable, поля класса B сериализованы не будут.

		 Последний момент – наследование. При наследовании от класса, реализующего Serializable, никаких дополнительных действий предпринимать не надо. Сериализация будет распространяться и на дочерний класс. При наследовании от класса, реализующего Externalizable, необходимо переопределить методы родительского класса readExternal и writeExternal. Иначе поля дочернего класса сериализованы не будут. В этом случае надо бы не забыть вызвать родительские методы, иначе не сериализованы будут уже родительские поля.
		 */
	}

	public static class B implements Serializable {
		private C c;

		public void setC(C c) {
			this.c = c;
		}

		public C getC() {
			return c;
		}
	}

	public static class C implements Serializable {
		private B b;

		public void setB(B b) {
			this.b = b;
		}

		public B getB() {
			return b;
		}
	}
}
