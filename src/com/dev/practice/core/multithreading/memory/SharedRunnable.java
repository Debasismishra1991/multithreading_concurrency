package com.dev.practice.core.multithreading.memory;

//Shared Runnable
//Expected Result : 2000000
//Actual Result : always below 2000000
public class SharedRunnable {

	public static void main(String[] args) {

		ThreadMemoryRunnable runnable1 = new ThreadMemoryRunnable();

		Thread t1 = new Thread(runnable1, "Thread 1");
		Thread t2 = new Thread(runnable1, "Thread 2");

		t1.start();
		t2.start();

	}

}
