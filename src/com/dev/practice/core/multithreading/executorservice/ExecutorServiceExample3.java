package com.dev.practice.core.multithreading.executorservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample3 {

	public static void main(String[] args) {

		int corePoolSize = 10;
		int maxPoolSize = 20;
		long keepAliveTime = 3000;

		ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
				TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(128));

		List<Callable<String>> callableList = new ArrayList<Callable<String>>();
		callableList.add(newCallable("Task 1"));
		callableList.add(newCallable("Task 2"));
		callableList.add(newCallable("Task 3"));
		callableList.add(newCallable("Task 4"));
		callableList.add(newCallable("Task 5"));
		try {
			List<Future<String>> futureList = executorService.invokeAll((Collection<Callable<String>>) callableList);
			for (Future<String> future : futureList) {
				String result = (String) future.get();
				System.out.println("Result :" + result);
			}
		} catch (Exception e) {
		}

		executorService.shutdown();
	}

	private static Callable<String> newCallable(String msg) {
		return new Callable<String>() {
			@Override
			public String call() {
				String completeMsg = Thread.currentThread().getName() + " : " + msg;
				System.out.println(completeMsg);
				return completeMsg;
			}
		};
	}
}
