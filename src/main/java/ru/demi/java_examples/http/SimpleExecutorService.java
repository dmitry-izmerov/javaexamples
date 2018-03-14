package ru.demi.java_examples.http;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * Created by demi
 * on 16.07.15.
 */
public class SimpleExecutorService {
	private final ThreadGroup group = new ThreadGroup("");
	private final Collection<Thread> workersPool = new ArrayList<>();
	private final BlockingQueue<Callable> taskQueue;

	public SimpleExecutorService(int threadCount, final BlockingQueue<Callable> taskQueue) {
		this.taskQueue = taskQueue;
		for (int i = 0; i < threadCount; i++) {
			Thread worker = new Thread(group, new Worker());
			worker.start();
			workersPool.add(worker);
		}
	}

	private class Worker implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					// TODO what difference - take/remove/poll/element/peek
					Callable nextTask = taskQueue.take();
					nextTask.call();
				} catch (InterruptedException e) {
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public <T> void submit(Callable<T> task) throws InterruptedException {
		taskQueue.put(task);
	}

	public void shutdown() {
		group.interrupt();
	}
}
