package dev.abhinav.threading;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class WriterThread extends Thread {

	private Counter counter;
	private ReentrantReadWriteLock lock;

	public WriterThread(Counter counter, ReentrantReadWriteLock lock, String threadName) {
		this.counter = counter;
		this.lock = lock;
		this.setName(threadName);
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String action = "";
			
			//acquire write lock
			WriteLock writeLock = lock.writeLock();
			System.out.println("Thread " + this.getName() + " is trying to acquire write lock");
			writeLock.lock();
			System.out.println("Thread " + this.getName() + " has acquired write lock..Number of readers "+lock.getReadLockCount());
			Random random = new Random();
			boolean isIncrement = random.nextBoolean();
			if (isIncrement) {
				action = "increments";
				synchronized (counter) {
					counter.increment();
				}
			} else {
				synchronized (counter) {
					counter.decrement();
				}
				action = "decrements";
			}

			System.out.println(
					"Thread " + this.getName() + " " + action + " value of counter to be " + counter.getValue());
			
			writeLock.unlock();
			System.out.println("Thread " + this.getName() + " is releasing write lock");
		}
	}

}
