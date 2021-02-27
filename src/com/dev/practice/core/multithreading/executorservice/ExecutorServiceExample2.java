package com.dev.practice.core.multithreading.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample2 {

	public static void main(String[] args) {

		int corePoolSize = 10;
		int maxPoolSize = 20;
		long keepAliveTime = 3000;

		ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
				TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(128));

		List<Future> futureList = new ArrayList<>();
		futureList.add(executorService.submit(newCallable("Task 1")));
		futureList.add(executorService.submit(newCallable("Task 2")));
		futureList.add(executorService.submit(newCallable("Task 3")));
		futureList.add(executorService.submit(newCallable("Task 4")));
		futureList.add(executorService.submit(newCallable("Task 5")));

		for (Future future : futureList) {
			System.out.println(future.isDone());
			try {
				String result = (String) future.get();
				System.out.println("Result :" + result);
			} catch (Exception e) {
			}
		}

		executorService.shutdown();
	}

	private static Callable newCallable(String msg) {
		return new Callable() {
			@Override
			public Object call() {
				String completeMsg = Thread.currentThread().getName() + " : " + msg;
				System.out.println(completeMsg);
				return completeMsg;
			}
		};
	}
}
