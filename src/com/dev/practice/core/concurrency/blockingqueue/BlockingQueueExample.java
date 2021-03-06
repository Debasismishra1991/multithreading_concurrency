package com.dev.practice.core.concurrency.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
	public static void main(String[] args) throws Exception {

		BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}

	public static class Producer implements Runnable {

		protected BlockingQueue<String> queue = null;

		public Producer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		public void run() {
			try {
				queue.put("1");
				System.out.println("Producer put : 1 in the blocking queue");
				Thread.sleep(1000);
				queue.put("2");
				System.out.println("Producer put : 2 in the blocking queue");
				Thread.sleep(1000);
				queue.put("3");
				System.out.println("Producer put : 3 in the blocking queue");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class Consumer implements Runnable {

		protected BlockingQueue<String> queue = null;

		public Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		public void run() {
			try {
				System.out.println("Consumer consume : " + queue.take() + " from the blocking queue");
				System.out.println("Consumer consume : " + queue.take() + " from the blocking queue");
				System.out.println("Consumer consume : " + queue.take() + " from the blocking queue");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
