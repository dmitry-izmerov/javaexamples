package ru.demi.java_examples.java_core.date;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SortDatesApp {
	public static void main(String[] args) {
		List<ObjWithDate> sorted = getReverseSortedObjWithDates();

		System.out.println(sorted);
	}

	private static List<ObjWithDate> getReverseSortedObjWithDates() {
		ObjWithDate d1 = new ObjWithDate("1", new Date(2018, 1, 1));
		ObjWithDate d2 = new ObjWithDate("2", new Date(2018, 0, 1));
		ObjWithDate d3 = new ObjWithDate("3", new Date(2017, 0, 1));
		ObjWithDate d4 = new ObjWithDate("4", new Date(2017, 1, 1));
		ObjWithDate d5 = new ObjWithDate("5", new Date(2017, 2, 1));
		ObjWithDate d6 = new ObjWithDate("6", new Date(2017, 3, 1));
		ObjWithDate d7 = new ObjWithDate("7", new Date(2017, 4, 1));
		ObjWithDate d8 = new ObjWithDate("8", new Date(2017, 5, 1));
		ObjWithDate d9 = new ObjWithDate("9", new Date(2017, 6, 1));
		ObjWithDate d10 = new ObjWithDate("10", new Date(2017, 7, 1));
		ObjWithDate d11 = new ObjWithDate("11", new Date(2017, 8, 1));
		ObjWithDate d12 = new ObjWithDate("12", new Date(2017, 9, 1));
		ObjWithDate d13 = new ObjWithDate("13", new Date(2017, 10, 1));
		ObjWithDate d14 = new ObjWithDate("14", new Date(2017, 11, 1));

		List<ObjWithDate> items = Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14);

		 return items.stream()
			.sorted(Comparator.reverseOrder())
			.limit(6)
			.collect(Collectors.toList());
	}


	private static List<ObjWithLocalDate> getReverseSortedObjWithLocalDates() {
		ObjWithLocalDate d1 = new ObjWithLocalDate("1", LocalDate.of(2018, Month.FEBRUARY, 1));
		ObjWithLocalDate d2 = new ObjWithLocalDate("2", LocalDate.of(2018, Month.JANUARY, 1));
		ObjWithLocalDate d3 = new ObjWithLocalDate("3", LocalDate.of(2017, Month.JANUARY, 1));
		ObjWithLocalDate d4 = new ObjWithLocalDate("4", LocalDate.of(2017, Month.FEBRUARY, 1));
		ObjWithLocalDate d5 = new ObjWithLocalDate("5", LocalDate.of(2017, Month.MARCH, 1));
		ObjWithLocalDate d6 = new ObjWithLocalDate("6", LocalDate.of(2017, Month.APRIL, 1));
		ObjWithLocalDate d7 = new ObjWithLocalDate("7", LocalDate.of(2017, Month.MAY, 1));
		ObjWithLocalDate d8 = new ObjWithLocalDate("8", LocalDate.of(2017, Month.JUNE, 1));
		ObjWithLocalDate d9 = new ObjWithLocalDate("9", LocalDate.of(2017, Month.JULY, 1));
		ObjWithLocalDate d10 = new ObjWithLocalDate("10", LocalDate.of(2017, Month.AUGUST, 1));
		ObjWithLocalDate d11 = new ObjWithLocalDate("11", LocalDate.of(2017, Month.SEPTEMBER, 1));
		ObjWithLocalDate d12 = new ObjWithLocalDate("12", LocalDate.of(2017, Month.OCTOBER, 1));
		ObjWithLocalDate d13 = new ObjWithLocalDate("13", LocalDate.of(2017, Month.NOVEMBER, 1));
		ObjWithLocalDate d14 = new ObjWithLocalDate("14", LocalDate.of(2017, Month.DECEMBER, 1));

		List<ObjWithLocalDate> items = Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14);

		 return items.stream()
			.sorted(Comparator.reverseOrder())
			.limit(6)
			.collect(Collectors.toList());
	}

	private static class ObjWithDate implements Comparable<ObjWithDate> {
		String id;
		Date date;

		public ObjWithDate(String id, Date date) {
			this.id = id;
			this.date = date;
		}

		@Override
		public int compareTo(ObjWithDate o) {
			return date.compareTo(o.date);
		}

		@Override
		public String toString() {
			return "{" +
				"id=" + id +
				", date=" + date +
				'}';
		}
	}

	private static class ObjWithLocalDate implements Comparable<ObjWithLocalDate> {
		String id;
		LocalDate date;

		public ObjWithLocalDate(String id, LocalDate date) {
			this.id = id;
			this.date = date;
		}

		@Override
		public int compareTo(ObjWithLocalDate o) {
			return date.compareTo(o.date);
		}

		@Override
		public String toString() {
			return "{" +
				"id=" + id +
				", date=" + date +
				'}';
		}
	}
}
