package com.dev.practice.core.multithreading.synchronize;

public class VolatileExchanger {

	private Object object = null;
	private volatile boolean hasNewObject = false;

	public void setObject(Object obj) {
		this.object = obj;
		this.hasNewObject = true;
	}

	public Object getObject() {
		while (!this.hasNewObject) {
			//
		}
		Object returnValue = this.object;
		this.hasNewObject = false;
		return returnValue;
	}
}
