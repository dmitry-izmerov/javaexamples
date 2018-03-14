package ru.demi.java_examples.java_core.calendar;

import java.util.Calendar;

/**
 * Created by demi
 * on 05.06.15.
 */
public class Main {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.JANUARY, 1, 0, 0);
		long day = c.getTimeInMillis();
		day += 1000 * 3600;
		c.setTimeInMillis(day);
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		c.add(Calendar.DAY_OF_MONTH, 30);
		System.out.println(c.getTime());
		c.roll(Calendar.DAY_OF_MONTH, 30);
		System.out.println(c.getTime());
		c.set(Calendar.DAY_OF_MONTH, 3);
		System.out.println(c.getTime());
	}
}
