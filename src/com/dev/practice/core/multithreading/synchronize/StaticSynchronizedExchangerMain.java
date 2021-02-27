package com.dev.practice.core.multithreading.synchronize;

public class StaticSynchronizedExchangerMain {

	public static void main(String[] args) {
		StaticSynchronizedExchanger synchronizedExchanger = new StaticSynchronizedExchanger();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					synchronizedExchanger.setObject("" + i);
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println(synchronizedExchanger.getObject());
				}
			}
		});
		thread1.start();
		thread2.start();
	}

}
