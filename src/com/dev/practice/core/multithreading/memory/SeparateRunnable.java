package com.dev.practice.core.multithreading.memory;

//Separate Runnable
public class SeparateRunnable {

	public static void main(String[] args) {

		ThreadMemoryRunnable runnable1 = new ThreadMemoryRunnable();
		ThreadMemoryRunnable runnable2 = new ThreadMemoryRunnable();

		Thread t1 = new Thread(runnable1, "Thread 1");
		Thread t2 = new Thread(runnable2, "Thread 2");

		t1.start();
		t2.start();

	}

}
