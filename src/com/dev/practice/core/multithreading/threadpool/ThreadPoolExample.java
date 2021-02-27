package com.dev.practice.core.multithreading.threadpool;

public class ThreadPoolExample {

	public static void main(String[] args) {
		ThreadPool threadPool = new ThreadPool(3, 10);

		for (int i = 0; i < 10; i++) {
			int taskNo = i;
			try {
				threadPool.execute(() -> {
					String message = Thread.currentThread().getName() + " : Task" + taskNo;
					System.out.println(message);
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		threadPool.waitUntilAllTasksFinished();
		threadPool.stop();
	}
}
