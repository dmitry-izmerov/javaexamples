package ru.demi.java_examples.java_8.date_and_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Created by demi
 * on 04.09.15.
 */
public class App04 {
	public static void main(String[] args) {
		// Formatting and parsing

		// Formatting and parsing is another big topic when working with dates and times.
		// In Java 8 this can be accomplished by using the format() and parse() methods:
		LocalDateTime dateTime = LocalDateTime.of(2015, Month.SEPTEMBER, 1, 9, 30);
		System.out.println(dateTime);

		// format as basic ISO date format YYYYMMDD
		String asBasicIsoDate = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(asBasicIsoDate);

		// format as ISO week date 2015-W36-2
		String asIsoWeekDate = dateTime.format(DateTimeFormatter.ISO_WEEK_DATE);
		System.out.println(asIsoWeekDate);

		// format as ISO date time 2015-09-01T09:30:00
		String asIsoDateTime = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
		System.out.println(asIsoDateTime);

		// using a custom pattern (01-09-2015)
		String asCustomPattern = dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		System.out.println(asCustomPattern);

		// french date formatting (1. septembre 2015)
		String frenchDate = dateTime.format(DateTimeFormatter.ofPattern("d. MMMM yyyy", new Locale("fr")));
		System.out.println(frenchDate);

		// using short german date/time formatting (01.09.15 09:30)
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("de"));
		String germanDateTime = dateTime.format(formatter);
		System.out.println(germanDateTime);

		// parsing date strings
		LocalDate fromIsoDate = LocalDate.parse("2015-10-20");
		System.out.println(fromIsoDate);

		LocalDate fromIsoWeekDate = LocalDate.parse("2015-W14-2", DateTimeFormatter.ISO_WEEK_DATE);
		System.out.println(fromIsoWeekDate);

		LocalDate fromCustomPattern = LocalDate.parse("15.09.2015", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		System.out.println(fromCustomPattern);

		DateTimeFormatter DATE_FORMATTER_PSQL = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.nnnnnn");
		LocalDateTime ldt = LocalDateTime.parse("2015-10-03 15:12:23.000000", DATE_FORMATTER_PSQL);
		System.out.println(ldt);
		System.out.println(ldt.format(DATE_FORMATTER_PSQL));
	}
}
