package dev.abhinav.threading;

public class MainRunner {

	public static void main(String[] args) throws InterruptedException {
		int startRunDurationInSeconds=5;
		Counter counter=new Counter();
		ThreadA threadA=new ThreadA(counter, startRunDurationInSeconds);
		ThreadRecorder.addThreadToRecorder("ThreadA", threadA);
		ThreadB threadB=new ThreadB(counter);
		ThreadRecorder.addThreadToRecorder("ThreadB", threadB);
		threadA.start();
		System.out.println("started thread A..will start thread B 3 seconds after");
		Thread.sleep(3000);
		threadB.start();
	}

}
