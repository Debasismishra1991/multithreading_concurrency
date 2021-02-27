package com.dev.practice.core.multithreading;

//by implementing Runnable
public class CreateThread2 {

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t = new Thread(mt);
		t.start();
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("I am Parent thread " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class MyThread implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println("I am child thread " + i);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
