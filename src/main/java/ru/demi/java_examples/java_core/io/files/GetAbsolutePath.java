package ru.demi.java_examples.java_core.io.files;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by demi
 * on 25.06.15.
 */
public class GetAbsolutePath {
	public static void main(String[] args) {
		Path path = Paths.get(".");
		File file = path.toFile();
		System.out.println(file.getAbsolutePath());
	}
}
