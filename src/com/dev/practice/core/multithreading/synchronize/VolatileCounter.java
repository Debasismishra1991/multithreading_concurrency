package com.dev.practice.core.multithreading.synchronize;

public class VolatileCounter {

	private volatile int count = 0;

	public boolean inc() {
		if (this.count == 100) {
			return false;
		}
		this.count++;
		return true;
	}

	public int getCount() {
		return this.count;
	}
}
