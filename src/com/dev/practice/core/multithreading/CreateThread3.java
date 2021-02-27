package com.dev.practice.core.multithreading;

// by annonymous class
public class CreateThread3 {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
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
		});
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

}
