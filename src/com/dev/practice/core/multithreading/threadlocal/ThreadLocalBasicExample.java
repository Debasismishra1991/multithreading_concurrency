package com.dev.practice.core.multithreading.threadlocal;

public class ThreadLocalBasicExample {

	public static void main(String[] args) {

		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		
		Thread thread1 = new Thread(()-> {
			threadLocal.set("Thread 1");
			try {
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String value = threadLocal.get();
			System.out.println("Thread1 local value "+value);
		});
		
		Thread thread2 = new Thread(()-> {
			threadLocal.set("Thread 2");
			try {
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String value = threadLocal.get();
			System.out.println("Thread2 local value "+value);
		});
		
		thread1.start();
		thread2.start();
	}

}
