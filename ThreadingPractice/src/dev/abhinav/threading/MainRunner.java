package dev.abhinav.threading;

public class MainRunner {

	public static void main(String[] args) throws InterruptedException {
		//scenario2Approach1Solution();
		scenario2Approach2Solution();
	}
	
	private static void scenario2Approach1Solution() throws InterruptedException
	{

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
	
	private static void scenario2Approach2Solution() throws InterruptedException
	{

		int startRunDurationInSeconds=5;
		Counter counter=new Counter();
		ThreadA2_2 threadA=new ThreadA2_2(counter, startRunDurationInSeconds);
		ThreadB2_2 threadB=new ThreadB2_2(counter);
		threadA.start();
		System.out.println("started thread A..will start thread B 3 seconds after");
		Thread.sleep(3000);
		threadB.start();
	
	}

}
