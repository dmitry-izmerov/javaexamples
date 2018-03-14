package ru.demi.java_examples.java_core.inner_classes;

import java.util.Collections;
import java.util.List;

/**
 * @author demi
 * @date 11.12.16
 */
public class Report {

	private String connection = "connection";

	public class Query {
		public static final String SOME = "some constant";

		// inner classes cannot have static declarations!!!
		// private static int field = 1;
		// public static void method() {}

		private Query() {
			System.out.println(SOME);
		}

		public List<Report> findAll() {
			return Collections.emptyList();
		}

		public Report findById(String id) {
			return null;
		}

		public boolean update(String id) {
			return true;
		}

		public boolean delete(String id) {
			return true;
		}

		public void installConnection() {
			System.out.println(Report.this.connection + " is installed.");
		}

		// its forbidden to declare enums in inner classes
		// enum DBTypes {}
	}

	public static void main(String[] args) {
		Report report = new Report();
		Report.Query query = report.new Query();
		query.installConnection();
		query.findAll();
	}

	/**
	 * Еще одна важная особенность - интерфейсы в Java не могут быть инстанциированы,
	 * соответственно объявить нестатический внутренний интерфейс нельзя,
	 * так как элементарно не будет объекта для ассоциации с экземпляром внешнего класса. Объявление вида:
	 */
	public interface SomeInterface {
	}

	// на самом деле будет интерпретироваться так:
	// public static interface SomeInterface {}
}
