package ru.demi.java_examples.java_8.date_and_time;

import java.time.*;

/**
 * Created by demi
 * on 04.09.15.
 */
public class App03 {
	public static void main(String[] args) {
		// Periods and Durations

		// Period and Duration are two other important classes.
		// Like the names suggest they represent a quantity or amount of time.
		// A Period uses date based values (years, months, days) while a Duration uses seconds or nanoseconds
		// to define an amount of time. Duration is most suitable when working with Instants and machine time.
		// Periods and Durations can contain negative values if the end point occurs before the starting point.

		// periods
		LocalDate firstDate = LocalDate.of(2015, 9, 1);
		LocalDate secondDate = LocalDate.of(2015, 9, 12);
		Period period = Period.between(firstDate, secondDate);
		System.out.println(period);

		int days = period.getDays();
		int months = period.getMonths();
		int years = period.getYears();
		boolean isNegative = period.isNegative();

		Period threeMonthsAndFourDays = Period.ofMonths(3).plusDays(4);
		LocalDate seventhOfJanuary = LocalDate.of(2015, 1, 7);
		// add three months and four days to 2015-01-07, result is 2015-04-11
		LocalDate resultDate = seventhOfJanuary.plus(threeMonthsAndFourDays);
		System.out.println(resultDate);

		// durations
		Instant firstInstant = Instant.ofEpochSecond(1294881180); // 2011-01-13 01:13
		Instant secondInstant = Instant.ofEpochSecond(1294708260); // 2011-01-11 01:11

		Duration between = Duration.between(firstInstant, secondInstant);

		// negative because firstInstant is after secondInstant (-172920)
		long seconds = between.getSeconds();
		System.out.println(seconds);

		// get absolute result in minutes (2882)
		long absoluteResult = between.abs().toMinutes();
		System.out.println(absoluteResult);

		// two hours in seconds (7200)
		long twoHoursInSeconds = Duration.ofHours(2).getSeconds();
		System.out.println(twoHoursInSeconds);
	}
}
