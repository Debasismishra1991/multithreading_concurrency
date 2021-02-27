package com.dev.practice.core.multithreading.racecondition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CheckAndActBehaviour {

	public static void main(String[] args) {
		Map<String, String> sharedMap = new ConcurrentHashMap<String, String>();

//		Thread thread1 = new Thread(getRunnable(sharedMap), "Thread 1");
//		Thread thread2 = new Thread(getRunnable(sharedMap), "Thread 2");

		Thread thread1 = new Thread(getSynchronizedRunnable(sharedMap), "Thread 1");
		Thread thread2 = new Thread(getSynchronizedRunnable(sharedMap), "Thread 2");
		thread1.start();
		thread2.start();
	}

	public static Runnable getRunnable(Map<String, String> sharedMap) {
		return () -> {
			for (int i = 0; i < 100000; i++) {
				if (sharedMap.containsKey("key")) {
					String val = sharedMap.remove("key");
					// as concurrent hashmap will not allow both thread to remove
					// one thread will remove and one thread will get null
					if (null == val) {
						System.out.println("Iteraction : " + i + ": Value for 'key' was null");
					}
				} else {
					sharedMap.put("key", "value");
				}
			}
			System.out.println(Thread.currentThread().getName() + " terminate");
		};
	}

	public static Runnable getSynchronizedRunnable(Map<String, String> sharedMap) {
		return () -> {
			for (int i = 0; i < 100000; i++) {
				synchronized (sharedMap) {
					if (sharedMap.containsKey("key")) {
						String val = sharedMap.remove("key");
						// as concurrent hashmap will not allow both thread to remove
						// one thread will remove and one thread will get null
						if (null == val) {
							System.out.println("Iteraction : " + i + ": Value for 'key' was null");
						}
					} else {
						sharedMap.put("key", "value");
					}
				}
			}
			System.out.println(Thread.currentThread().getName() + " terminate");
		};
	}
}
