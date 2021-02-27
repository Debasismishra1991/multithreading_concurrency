package com.dev.practice.core.multithreading;

// by extending Thread class
public class CreateThread1 {

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("I am Parent thread " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class MyThread extends Thread {
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
