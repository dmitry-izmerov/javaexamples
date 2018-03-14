package ru.demi.java_examples.java_core.enumeration;

/**
 * @author demi
 * @date 14.01.17
 */
public class CorrectAndIncorrectEnums {
	enum Day1 {
		Sunday, Monday, Tuesday;
		private String holiday;
	}

	enum Day2 {
		Sunday, Monday, Tuesday;
		private String holiday;

		Day2() {
			System.out.println("Hello");
		}
	}

    /*enum Day {
        Sunday, Monday, Tuesday,
        private String holiday;
    }*/

	enum Day3 {
		Sunday, Monday, Tuesday
	}

    /*enum Day {
        private String holiday;
        Sunday, Monday, Tuesday;
    }*/
}
