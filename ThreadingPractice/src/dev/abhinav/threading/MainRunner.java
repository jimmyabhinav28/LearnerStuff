package dev.abhinav.threading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainRunner {

	public static void main(String[] args) throws InterruptedException {
		// scenario2Approach1Solution();
		// scenario2Approach2Solution();
		readersWriterUsingReentrantReadWriteLock();
	}

	private static void scenario2Approach1Solution() throws InterruptedException {

		int startRunDurationInSeconds = 5;
		Counter counter = new Counter();
		ThreadA threadA = new ThreadA(counter, startRunDurationInSeconds);
		ThreadRecorder.addThreadToRecorder("ThreadA", threadA);
		ThreadB threadB = new ThreadB(counter);
		ThreadRecorder.addThreadToRecorder("ThreadB", threadB);
		threadA.start();
		System.out.println("started thread A..will start thread B 3 seconds after");
		Thread.sleep(3000);
		threadB.start();

	}

	private static void scenario2Approach2Solution() throws InterruptedException {

		int startRunDurationInSeconds = 5;
		Counter counter = new Counter();
		ThreadA2_2 threadA = new ThreadA2_2(counter, startRunDurationInSeconds);
		ThreadB2_2 threadB = new ThreadB2_2(counter);
		threadA.start();
		System.out.println("started thread A..will start thread B 3 seconds after");
		Thread.sleep(3000);
		threadB.start();

	}

	private static void readersWriterUsingReentrantReadWriteLock() {
		Counter counter = new Counter();
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		ReaderThread readerThread1 = new ReaderThread(counter, lock, "reader1");
		ReaderThread readerThread2 = new ReaderThread(counter, lock, "reader2");
		ReaderThread readerThread3 = new ReaderThread(counter, lock, "reader3");

		WriterThread writerThread1 = new WriterThread(counter, lock, "writer1");
		WriterThread writerThread2 = new WriterThread(counter, lock, "writer2");

		readerThread1.start();
		readerThread2.start();
		readerThread3.start();
		writerThread1.start();
		writerThread2.start();
	}

}
