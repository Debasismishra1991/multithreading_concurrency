package com.dev.practice.core.multithreading.memory;

//Shared Runnable
//Expected Result : 2000000
//Actual Result : 
//Thread 2 : 1069101
//Thread 1 : 2000000
public class SharedRunnable2 {

	public static void main(String[] args) {

		ThreadMemorySynchronizedRunnable runnable1 = new ThreadMemorySynchronizedRunnable();

		Thread t1 = new Thread(runnable1, "Thread 1");
		Thread t2 = new Thread(runnable1, "Thread 2");

		t1.start();
		t2.start();

	}

}
