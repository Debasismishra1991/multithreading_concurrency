package com.dev.practice.core.concurrency.blockingqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {

	public static void main(String[] args) {
		DelayQueue<Delayed> queue = new DelayQueue<>();

		Delayed element1 = new DelayedElement();

		queue.put(element1);

		try {
			Delayed element2 = queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static class DelayedElement implements Delayed {

		@Override
		public int compareTo(Delayed arg0) {
			return this.compareTo(arg0);
		}

		@Override
		public long getDelay(TimeUnit unit) {
			return 0;
		}
	}
}