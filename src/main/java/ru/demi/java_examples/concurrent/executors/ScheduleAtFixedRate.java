package ru.demi.java_examples.concurrent.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author demi
 * @date 10.05.16
 */
public class ScheduleAtFixedRate {
	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		Runnable task = () -> System.out.println("Scheduling: " + System.currentTimeMillis());

		int initialDelay = 0;
		int period = 1;
		ScheduledFuture<?> future = executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);


		TimeUnit.SECONDS.sleep(6);

		System.out.printf("Remaining delay: %sms", future.getDelay(TimeUnit.MILLISECONDS));

		executor.shutdownNow();
	}
}
