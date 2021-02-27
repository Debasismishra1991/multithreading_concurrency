package com.dev.practice.core.multithreading;

//Child Thread waits till Main Terminate
public class JoinThread2 {

	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.mt = Thread.currentThread();
		t.start();
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("I am Parent thread " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Main thread terminate");

	}

	public static class MyThread extends Thread {
		static Thread mt;

		@Override
		public void run() {
			try {
				for (int i = 0; i < 5; i++) {
					System.out.println("I am Child thread " + i);
					Thread.sleep(1000);
				}
				mt.join();
				System.out.println("Child thread terminate");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
