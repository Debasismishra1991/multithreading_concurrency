package com.dev.practice.core.multithreading.synchronize;

public class VolatileCounterMain {

	public static void main(String[] args) {
		VolatileCounter volatileCounter = new VolatileCounter();

		Thread thread1 = new Thread(() -> {
			for(int i=0;i<100;i++) {
				volatileCounter.inc();
			}
			System.out.println("Counter "+volatileCounter.getCount());
		});

		Thread thread2 = new Thread(() -> {
			for(int i=0;i<100;i++) {
				volatileCounter.inc();
			}
			System.out.println("Counter "+volatileCounter.getCount());
		});

		thread1.start();
		thread2.start();
	}
}
