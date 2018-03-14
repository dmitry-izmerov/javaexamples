package ru.demi.java_examples.java_8.date_and_time;

import java.time.*;

/**
 * Created by demi
 * on 04.09.15.
 */
public class App01 {
	public static void main(String[] args) {

		// All classes of the Java 8 Date/Time API are located within the java.time package

		// the current date
		LocalDate current = LocalDate.now();

		// 2015-07-07
		LocalDate seventhJuly = LocalDate.of(2015, Month.JULY, 7);
		System.out.println(seventhJuly);

		// months values start at 1
		LocalDate firstAug2015 = LocalDate.of(2015, 8, 1);
		System.out.println(firstAug2015);

		// the 65th day of 2010
		LocalDate sixtyFirthDayOf2010 = LocalDate.ofYearDay(2010, 65);
		System.out.println(sixtyFirthDayOf2010);

		LocalTime localTimeCurrent = LocalTime.now();
		System.out.println(localTimeCurrent);

		LocalTime midday = LocalTime.of(12, 0);
		System.out.println(midday);

		LocalTime afterMidday = LocalTime.of(13, 20, 15);
		System.out.println(afterMidday);

		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println(currentDateTime);

		LocalDateTime fifthAug2015 = LocalDateTime.of(2015, 8, 5, 14, 30);
		System.out.println(fifthAug2015);

		LocalDateTime christmas2015 = LocalDateTime.of(2015, 12, 24, 12, 0);
		System.out.println(christmas2015);

		// By default LocalDate/Time classes will use the system clock in the default time zone.
		// We can change this by providing a time zone or an alternative Clock implementation:
		LocalTime currentTimeInLosAngeles = LocalTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println(currentTimeInLosAngeles);

		// current time in UTC time zone
		LocalTime nowInUtc = LocalTime.now(Clock.systemUTC());
		System.out.println(nowInUtc);

		LocalDate date = LocalDate.of(2015, 9, 4);
		System.out.println(LocalDate.now().isBefore(date)); // false
		System.out.println(LocalDate.now().isAfter(date));  // true

		// information about the month
		System.out.println("============== information about the month ================");
		Month september = date.getMonth();
		System.out.println(september);
		int septemberIntValue = september.getValue();
		System.out.println(septemberIntValue);
		int minLength = september.minLength();
		System.out.println(minLength);
		int maxLength = september.maxLength();
		System.out.println(maxLength);

		Month february = Month.FEBRUARY;
		minLength = february.minLength();
		System.out.println(minLength);
		maxLength = february.maxLength();
		System.out.println(maxLength);

		Month firstMonthOfQuarter = september.firstMonthOfQuarter();
		System.out.println(firstMonthOfQuarter);

		// information about the year
		System.out.println("============== information about the year ================");
		int year = date.getYear();
		System.out.println("year - " + year);
		int dayOfYear = date.getDayOfYear();
		System.out.println("day of year - " + dayOfYear);
		int lengthOfYear = date.lengthOfYear();
		System.out.println("length of year - " + lengthOfYear);
		boolean isLeapYear = date.isLeapYear();
		System.out.println("is leap year - " + isLeapYear);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		System.out.println("day of week - " + dayOfWeek);
		int dayOfWeekIntValue = dayOfWeek.getValue();
		System.out.println("day of week int value - " + dayOfWeekIntValue);
		String dayOfWeekName = dayOfWeek.name();
		System.out.println("day of week name - " + dayOfWeekName);
		int dayOfMonth = date.getDayOfMonth();
		System.out.println("day of month - " + dayOfMonth);

		// time information
		System.out.println("============== time information ===========================");
		LocalTime time = LocalTime.of(17, 10, 10);
		int hour = time.getHour();
		System.out.println("hour - " + hour);
		int minute = time.getMinute();
		System.out.println("minute - " + minute);
		int second = time.getSecond();
		System.out.println("second - " + second);
		int secondOfDay = time.toSecondOfDay();
		System.out.println("second of day - " + secondOfDay);
	}
}
