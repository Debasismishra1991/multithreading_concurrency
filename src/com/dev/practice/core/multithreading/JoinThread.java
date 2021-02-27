package com.dev.practice.core.multithreading;

//Main Thread waits till Child Terminate
public class JoinThread {

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println("I am child thread " + i);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Child thread terminate");
		});
		t.start();
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("I am Parent thread " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
