package com.dev.practice.core.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronosBlockingQueueExample {
	public static void main(String[] args) throws Exception {

		BlockingQueue<String> queue = new SynchronousQueue<>();

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
				System.out.println("Producer put : 1 in the blocking queue");
				queue.put("1");
				System.out.println("Producer put : 2 in the blocking queue");
				queue.put("2");
				System.out.println("Producer put : 3 in the blocking queue");
				queue.put("3");
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
