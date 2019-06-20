package dev.abhinav.threading;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class ReaderThread extends Thread {

	// this is the shared counter object that is being read
	private Counter counter;
	private ReentrantReadWriteLock lock;

	public ReaderThread(Counter counter, ReentrantReadWriteLock lock, String threadName) {
		this.counter = counter;
		this.lock = lock;
		this.setName(threadName);
	}

	@Override
	public void run() {
		for (int i = 0; i < 6; i++) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// first acquire a read lock
			ReadLock readLock = lock.readLock();
			System.out.println("Thread " + this.getName() + " is trying to acquire read lock");
			readLock.lock();
			System.out.println("Thread " + this.getName() + " has acquired read lock..Number of readers "+lock.getReadLockCount());
			System.out.println("Thread " + this.getName() + " reads value of counter to be " + counter.getValue());
			readLock.unlock();
			System.out.println("Thread " + this.getName() + " is releasing read lock");
		}
	}

}
