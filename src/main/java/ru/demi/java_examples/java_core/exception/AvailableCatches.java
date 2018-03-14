package ru.demi.java_examples.java_core.exception;

import java.io.IOException;

/**
 * @author demi
 * @date 04.01.17
 */
public class AvailableCatches {

	public static void main(String[] args) {
		try {
			System.out.println("Exception try");
		} catch (Exception e) {
		}

		// its forbidden
        /*try {
            System.out.println("Exception try");
        } catch (IOException e) {}*/

		try {
			System.out.println("RuntimeException try");
		} catch (RuntimeException e) {
		}

		try {
			System.out.println("Error try");
		} catch (Error e) {
		}

		try {
			System.out.println("Throwable try");
		} catch (Throwable e) {
		}
	}

	/**
	 * Пояснение: Обработчик исключительной ситуации общего типа не должен предшествовать остальным, иначе исключение уже будет поймано и их код будет недостижим.
	 * Блоки try, catch и finally не могут разделяться никакими выражениями и пустой инструкцией ; в том числе.
	 * Если контролируемая исключительная ситуация не возбуждается нигде в блоке try, то и, следовательно,
	 * блок catch по контролируемой исключительной ситуации является недостижимым.
	 * Однако Exception, являющийся контролируемой исключительной ситуацией, в то же время является родителем
	 * неконтролируемой исключительной ситуации RuntimeException(и всех потомков этого класса). Компилятор считает, что неконтролируемая
	 * исключительная ситуация может возникнуть всегда, и, следовательно, обработчик по Exception является достижимым.
	 */
}
