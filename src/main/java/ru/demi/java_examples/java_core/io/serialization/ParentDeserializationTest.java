package ru.demi.java_examples.java_core.io.serialization;

import java.io.*;

/**
 * ParentDeserializationTest
 *
 * @author Eugene Matyushkin aka Skipy
 * @since 05.08.2010
 */
public class ParentDeserializationTest {

	public static void main(String[] args) {
		try {
			System.out.println("Creating...");
			Child c = new Child(1);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			c.field = 10;
			System.out.println("Serializing...");
			oos.writeObject(c);
			oos.flush();
			baos.flush();
			oos.close();
			baos.close();

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			System.out.println("Deserializing...");
			Child c1 = (Child) ois.readObject();
			System.out.println("c1.i=" + c1.getI());
			System.out.println("c1.field=" + c1.getField());
			/**
			 * То есть при десериализации вызывается конструктор без параметров родительского НЕсериализуемого класса. И если такого конструктора не будет – при десериализации возникнет ошибка. Конструктор же дочернего объекта, того, который мы десериализуем, не вызывается, как и было сказано выше.

			 Так ведут себя стандартные механизмы при использовании Serializable. При использовании же Externalizable ситуация иная. Сначала вызывается конструктор без параметров, а потом уже на созданном объекте вызывается метод readExternal, который и вычитывает, собственно, все свои данные. Потому – любой реализующий интерфейс Externalizable класс обязан иметь public конструктор без параметров! Более того, поскольку все наследники такого класса тоже будут считаться реализующими интерфейс Externalizable, у них тоже должен быть конструктор без параметров!
			 */

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public static class Parent {
		protected int field;

		protected Parent() {
			field = 5;
			System.out.println("Parent::Constructor");
		}

		public int getField() {
			return field;
		}
	}

	public static class Child extends Parent implements Serializable {
		protected int i;

		public Child() {
			super();
			System.out.println("Child::Constructor without parameters!"); // this is not called!!!
		}

		public Child(int i) {
			this.i = i;
			System.out.println("Child::Constructor");
		}

		public int getI() {
			return i;
		}
	}
}
