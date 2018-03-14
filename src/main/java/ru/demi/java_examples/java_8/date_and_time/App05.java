package ru.demi.java_examples.java_8.date_and_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

/**
 * Created by demi
 * on 04.09.15.
 */
public class App05 {
	public static void main(String[] args) {
		// Conversion between different date / time objects

		// Of course we do not always have objects of the type we need.
		// Therefore, we need an option to convert different date/time related objects between each other.
		// The following examples show some of the possible conversion options:

		// LocalDate/LocalTime <-> LocalDateTime
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		LocalDate dateFromDateTime = LocalDateTime.now().toLocalDate();
		LocalTime timeFromDateTime = LocalDateTime.now().toLocalTime();

		// Instant <-> LocalDateTime
		Instant instant = Instant.now();
		LocalDateTime dateTimeFromInstant = LocalDateTime.ofInstant(instant, ZoneId.of("America/Los_Angeles"));
		Instant instantFromDateTime = LocalDateTime.now().toInstant(ZoneOffset.ofHours(3));

		// convert old date/calendar/timezone classes
		Instant instantFromDate = new Date().toInstant();
		Instant instantFromCalendar = Calendar.getInstance().toInstant();
		ZoneId zoneId = TimeZone.getDefault().toZoneId();
		ZonedDateTime zonedDateTime = new GregorianCalendar().toZonedDateTime();

		// convert to old classes
		Date dateFromInstant = Date.from(Instant.now());
		TimeZone timeZone = TimeZone.getTimeZone(ZoneId.of("America/Los_Angeles"));
		GregorianCalendar gregorianCalendar = GregorianCalendar.from(ZonedDateTime.now());

		// clear timestamp <=> timestamp
		long timeStamp = LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(2));
		LocalDateTime dateTimeFromTimestamp = LocalDateTime.ofEpochSecond(timeStamp, 0, ZoneOffset.ofHours(2));
	}
}
