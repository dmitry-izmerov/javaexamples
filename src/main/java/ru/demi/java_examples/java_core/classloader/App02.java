package ru.demi.java_examples.java_core.classloader;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/* ClassLoader - что это такое?
	Реализуйте логику метода getAllAnimals.
	Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
	Путь не обязательно содержит / в конце.
	НЕ все классы наследуются от интерфейса Animal.
	НЕ все классы имеют публичный конструктор без параметров.
	Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
	Добавить созданные объекты в результирующий сет и вернуть.
	Метод main не участвует в тестировании.
*/
public class App02 {
	public static void main(String[] args) {
		Set<? extends Animal> allAnimals = getAllAnimals("path/to/sources/");
		System.out.println(allAnimals);
	}

	public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
		Set<Animal> set = new HashSet<>();
		if (!pathToAnimals.endsWith(File.separator)) {
			pathToAnimals += File.separator;
		}

		final String path = pathToAnimals;
		ClassLoader classLoader = new ClassLoader() {
			@Override
			public Class<?> findClass(String className) throws ClassNotFoundException {
				try {
					byte bytes[] = getClassBytes(path + className + ".class");
					return defineClass(null, bytes, 0, bytes.length);
				} catch (FileNotFoundException ex) {
					return super.findClass(className);
				} catch (IOException ex) {
					return super.findClass(className);
				}
			}
		};

		File[] files = new File(pathToAnimals).listFiles();
		for (File file : files) {
			if (file.isFile() && file.toString().endsWith(".class")) {
				try {
					String className = file.getName();
					className = className.substring(0, className.length() - 6);
					Class<?> clazz = classLoader.loadClass(className);

					Class<?>[] interfaces = clazz.getInterfaces();
					boolean hasAnimalInterface = false;
					for (Class<?> i : interfaces) {
						if (i.getCanonicalName().equals(Animal.class.getCanonicalName())) {
							hasAnimalInterface = true;
							break;
						}
					}
					if (!hasAnimalInterface) {
						continue;
					}

					Constructor constructor = null;
					Constructor[] constructors = clazz.getConstructors();
					for (Constructor c : constructors) {
						if ((c.getModifiers() & Modifier.PUBLIC) != 0 && c.getParameterCount() == 0) {
							constructor = c;
							break;
						}
					}
					if (constructor == null) {
						continue;
					}

					Animal animal = (Animal) constructor.newInstance();
					set.add(animal);
				} catch (Exception e) {
				}
			}
		}

		return set;
	}

	private static byte[] getClassBytes(String filePath) throws IOException {
		InputStream is = new FileInputStream(filePath);
		long l = new File(filePath).length();
		byte[] bytes = new byte[(int) l];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}
		is.close();
		return bytes;
	}
}
