package com.dev.practice.core.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * <pre>
 * <b>Output :-</b>
Producer put : Employee3 in the blocking queue
Producer put : Employee1 in the blocking queue
Producer put : Employee2 in the blocking queue
Blocking queue items[Employee [empName=Employee1, empNo=1], Employee [empName=Employee3, empNo=3], Employee [empName=Employee2, empNo=2]]
Consumer consume : Employee [empName=Employee1, empNo=1] from the blocking queue
Consumer consume : Employee [empName=Employee2, empNo=2] from the blocking queue
Consumer consume : Employee [empName=Employee3, empNo=3] from the blocking queue
 * </pre>
 * 
 * @author demishra
 *
 */
public class PriorityBlockingQueueExample {
	public static void main(String[] args) throws Exception {

		BlockingQueue<Employee> queue = new PriorityBlockingQueue<>();

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}

	public static class Producer implements Runnable {

		protected BlockingQueue<Employee> queue = null;

		public Producer(BlockingQueue<Employee> queue) {
			this.queue = queue;
		}

		public void run() {
			try {
				queue.put(new Employee(3, "Employee3"));
				System.out.println("Producer put : Employee3 in the blocking queue");
				queue.put(new Employee(1, "Employee1"));
				System.out.println("Producer put : Employee1 in the blocking queue");
				queue.put(new Employee(2, "Employee2"));
				System.out.println("Producer put : Employee2 in the blocking queue");
				System.out.println("Blocking queue items" + queue);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class Consumer implements Runnable {

		protected BlockingQueue<Employee> queue = null;

		public Consumer(BlockingQueue<Employee> queue) {
			this.queue = queue;
		}

		public void run() {
			try {
				Thread.sleep(10000);
				System.out.println("Consumer consume : " + queue.take() + " from the blocking queue");
				System.out.println("Consumer consume : " + queue.take() + " from the blocking queue");
				System.out.println("Consumer consume : " + queue.take() + " from the blocking queue");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class Employee implements Comparable<Employee> {

		private String empName;
		private Integer empNo;

		public Employee(Integer empNo, String empName) {
			this.empNo = empNo;
			this.empName = empName;
		}

		@Override
		public int compareTo(Employee emp) {
			return this.empNo.compareTo(emp.getEmpNo());
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public Integer getEmpNo() {
			return empNo;
		}

		public void setEmpNo(Integer empNo) {
			this.empNo = empNo;
		}

		@Override
		public String toString() {
			return "Employee [empName=" + empName + ", empNo=" + empNo + "]";
		}

	}
}
