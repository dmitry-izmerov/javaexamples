package ru.demi.java_examples.java_8.date_and_time;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * Created by demi
 * on 04.09.15.
 */
public class App02 {
	public static void main(String[] args) {

		// Some information can be obtained without providing a specific date.
		// For example, we can use the Year class if we need information about a specific year
		Year currentYear = Year.now();
		System.out.println(currentYear);
		Year threeThousand = Year.of(3000);
		System.out.println(threeThousand);
		boolean isLeap = currentYear.isLeap();
		System.out.println(isLeap);
		int length = currentYear.length();
		System.out.println(length);

		// 256 day of 2015
		LocalDate date = Year.of(2015).atDay(256);
		System.out.println(date);

		// We can use the plus and minus methods to add or subtract specific amounts of time.
		// Note that these methods always return a new instance (Java 8 date/time classes are immutable).
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		System.out.println(tomorrow);

		// before 4 houres and 60 minutes
		LocalDateTime beforeDateTime = LocalDateTime.now().minusHours(4).minusMinutes(60);
		System.out.println(beforeDateTime);

		// TemporalAdjusters are another nice way for date manipulation.
		// TemporalAdjuster is a single method interface that is used to separate the process of adjustment
		// from actual date/time objects. A set of common TemporalAdjusters can be accessed using
		// static methods of the TemporalAdjusters class.
		date = LocalDate.of(2015, Month.FEBRUARY, 22);
		// first day of february 2015
		LocalDate firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(firstDayOfMonth);
		// last day of february 2015
		LocalDate lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(lastDayOfMonth);

		// Time zones

		// Working with time zones is another big topic that is simplified by the new API.
		// The LocalDate/Time classes we have seen so far do not contain information about a time zone.
		// If we want to work with a date/time in a certain time zone we can use ZonedDateTime or OffsetDateTime:
		ZoneId losAngeles = ZoneId.of("America/Los_Angeles");
		ZoneId tokyo = ZoneId.of("Asia/Tokyo");

		LocalDateTime dateTime = LocalDateTime.of(2015, 9, 6, 10, 0);
		ZonedDateTime tokyoDateTime = ZonedDateTime.of(dateTime, tokyo);
		System.out.println(tokyoDateTime);
		ZonedDateTime dateTimeLA = tokyoDateTime.withZoneSameInstant(losAngeles);
		System.out.println(dateTimeLA);
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		System.out.println(allZoneIds);

		// using offsets
		dateTime = LocalDateTime.of(2015, Month.JULY, 22, 17, 30);
		ZoneOffset offset = ZoneOffset.of("+05:00");
		OffsetDateTime plusFive = OffsetDateTime.of(dateTime, offset);
		System.out.println(plusFive);
		OffsetDateTime minusTwo = plusFive.withOffsetSameInstant(ZoneOffset.ofHours(-2));
		System.out.println(minusTwo);

		// Timestamps

		// Classes like LocalDate and ZonedDateTime provide a human view on time.
		// However, often we need to work with time viewed from a machine perspective.
		// For this we can use the Instant class which represents timestamps.
		// An Instant counts the time beginning from the first second of January 1, 1970 (1970-01-01 00:00:00)
		// also called the EPOCH. Instant values can be negative if they occured before the epoch.
		// They follow ISO 8601 the standard for representing date and time.

		// current time
		Instant now = Instant.now();
		System.out.println(now); // get timestamp relative to UTC!!

		// from unix timestamp, 2010-01-01 12:00:00
		Instant fromUnixTimestamp = Instant.ofEpochSecond(1262347200);
		System.out.println(fromUnixTimestamp);

		// parsing from ISO 8601
		Instant fromIso8601 = Instant.parse("2010-01-01T12:00:00Z");
		System.out.println(fromIso8601);

		// as unix timestamp
		long toUnixTimestamp = now.getEpochSecond();
		System.out.println(toUnixTimestamp);

		// plus/minus methods are available too
		Instant nowPlusTwentySeconds = now.plusSeconds(20);
		System.out.println(nowPlusTwentySeconds);
	}
}
