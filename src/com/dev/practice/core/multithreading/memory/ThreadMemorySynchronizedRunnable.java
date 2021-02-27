package com.dev.practice.core.multithreading.memory;

public class ThreadMemorySynchronizedRunnable implements Runnable {
	int count = 0;

	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			synchronized (this) {
				this.count++;
			}
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.count);
	}
}