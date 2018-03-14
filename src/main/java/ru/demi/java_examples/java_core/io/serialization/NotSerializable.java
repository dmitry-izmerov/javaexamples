package ru.demi.java_examples.java_core.io.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author demi
 * @date 03.01.17
 */
public class NotSerializable {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		User user = new User(1, "user", "user@mail.com", "pass");
		try {
			oos.writeObject(user);
		} catch (NotSerializableException e) {
			System.out.println("Specially throw NotSerializableException");
		}

		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		try {
			System.out.println(ois.readObject());
		} catch (NotSerializableException e) {
			System.out.println("Specially throw NotSerializableException");
		}
	}

	private static class User implements Serializable {
		private static final long serialVersionUID = 1L;
		private long id;
		private String name;
		private String email;
		private String password;

		public User(long id, String name, String email, String password) {
			this.id = id;
			this.name = name;
			this.email = email;
			this.password = password;
		}

		@Override
		public String toString() {
			return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				'}';
		}

		// Serialization of an object can be prevented by implementing writeObject and readObject methods that throw the NotSerializableException
		private void writeObject(ObjectOutputStream oos) throws IOException {
			throw new NotSerializableException();
		}

		private void readObject(ObjectInputStream ois) throws IOException {
			throw new NotSerializableException();
		}
	}
}
