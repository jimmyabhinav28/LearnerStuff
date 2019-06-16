package dev.abhinav.threading;

/**
 * Counter is meant to be used as a shared object between threads
 * 
 * @author abhinav
 *
 */
public class Counter {
	public Counter() {
		value = 0;
	}

	private long value;

	public long getValue() {
		return value;
	}

	public synchronized long increment() {
		value++;
		return value;
	}

	public synchronized long decrement() {
		value--;
		return value;
	}

}
