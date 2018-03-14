package ru.demi.java_examples.java_core.io.files;

import java.net.URL;

/**
 * Created by demi
 * on 14.07.15.
 */
public class GetCurrentPathForFile {
	public static void main(String[] args) {
		String s = GetCurrentPathForFile.class.getName();
		int i = s.lastIndexOf(".");
		if (i > -1) s = s.substring(i + 1);
		s = s + ".class";
		URL testPath = GetCurrentPathForFile.class.getResource(s);
		System.out.println(testPath.getPath());
	}
}
