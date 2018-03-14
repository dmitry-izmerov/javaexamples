package ru.demi.java_examples.java_core.charset;

import java.nio.charset.Charset;

/**
 * Created by demi
 * on 05.07.15.
 * <p>
 * Required charsets for all JVM
 */
public class StandardCharsets {
	public static void main(String[] args) {
		Charset iso88591 = java.nio.charset.StandardCharsets.ISO_8859_1;
		Charset ascii = java.nio.charset.StandardCharsets.US_ASCII;
		Charset utf16 = java.nio.charset.StandardCharsets.UTF_16;
		Charset utf16be = java.nio.charset.StandardCharsets.UTF_16BE;
		Charset utf16le = java.nio.charset.StandardCharsets.UTF_16LE;
		Charset utf8 = java.nio.charset.StandardCharsets.UTF_8;
	}
}
