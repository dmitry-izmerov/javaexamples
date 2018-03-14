package ru.demi.java_examples.java_core.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by demi
 * on 08.08.15.
 */
public class DateFormating {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat("dd-MM-YY");
		String mes = formatter.format(calendar.getTime());
		System.out.println(mes);

		/**
		 *   Ключевое слово           Описание
		 *
		 *         y          вместо этого символа будет подставлен год
		 *         M          заменяется на месяц
		 *         w          номер недели в году
		 *         W          порядковый номер недели в месяце
		 *         D          номер дня в году
		 *         d          день месяца
		 *         F          номер дня недели в месяце
		 *         E          день недели
		 *         H          час в 24-часовом формате (0-23)
		 *         k          час в 24-часовом формате (1-24)
		 *         K          час в 12-часовом формате (0-11)
		 *         h          час в 12-часовом формате (1-12)
		 *         m          минуты
		 *         s          секунды
		 *         S          миллисекунды
		 */
	}
}
