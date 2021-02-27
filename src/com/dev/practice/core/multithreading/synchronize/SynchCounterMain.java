package com.dev.practice.core.multithreading.synchronize;

public class SynchCounterMain {

	public static void main(String[] args) {
		SynchCounter counter = new SynchCounter();
		
		Thread thread1 = new Thread(() -> {
			for(int i=0;i<100000;i++) {
				counter.incCount();
			}
			System.out.println(counter.getCount());
		});
		
		Thread thread2 = new Thread(() -> {
			for(int i=0;i<100000;i++) {
				counter.incCount();
			}
			System.out.println(counter.getCount());
		});
		
		thread1.start();
		thread2.start();
	}
}
