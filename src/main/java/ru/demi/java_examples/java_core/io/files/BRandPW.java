package ru.demi.java_examples.java_core.io.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

/**
 * @author demi
 * @date 05.02.17
 */
public class BRandPW {
	public static void main(String[] args) throws IOException {
		try (
			BufferedReader in = new BufferedReader(new FileReader(BRandPW.class.getResource("in.txt").getFile()));
			PrintWriter out = new PrintWriter(new FileWriter(BRandPW.class.getResource("out.txt").getFile()))
		) {
			String s;
			while ((s = in.readLine()) != null) {
				out.println(s);
			}
		}
	}
}
