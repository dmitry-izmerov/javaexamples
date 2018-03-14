package ru.demi.java_examples.java_core.io.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author demi
 * @date 03.01.17
 */
public class CustomSerialization {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		User user = new User(1, "user", "user@mail.com", "pass");
		oos.writeObject(user);

		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		System.out.println(ois.readObject());
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

		// it wont work!!!
		// its needed strictly same method signatures like in description of Serializable interface
        /*public void writeObject(ObjectOutputStream oos) throws IOException {
            oos.writeLong(id);
        }

        public void readObject(ObjectInputStream ois) throws IOException {
            id = ois.readLong();
        }*/

		private void writeObject(ObjectOutputStream oos) throws IOException {
			oos.writeLong(id);
		}

		private void readObject(ObjectInputStream ois) throws IOException {
			id = ois.readLong();
		}
	}
}
