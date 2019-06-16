/**
 * 
 */
package dev.abhinav.threading;

/**
 * @author abhinav
 *
 */
public class ThreadA extends Thread {
	
	private Counter counter;
	private int startRunDurationInSeconds;
	public ThreadA(Counter counter, int startRunDurationInSeconds)
	{
		this.counter=counter;
		this.startRunDurationInSeconds=startRunDurationInSeconds;
		this.setName("ThreadA");
	}
	@Override
	public void run() {
		try {
	
		//Starts by running for 5 seconds
		for(int i=0;i<startRunDurationInSeconds;i++)
		{
			Thread.sleep(1000);
			System.out.println(this.getName()+ " is executing. Incremented value of counter is "+counter.increment());
			
		}
		//now pause for 5 seconds
		Thread.sleep(5000);
		
		//now search for a thread named B
		Thread threadB=ThreadRecorder.getThreadByName("ThreadB");
		//if there is a threadB then wait for it to complete
		if(threadB!=null)
		{
			threadB.join();
		}
		
		for(int i=0;i<5;i++)
		{
			Thread.sleep(1000);
			synchronized (counter) {
				System.out.println(Thread.currentThread().getName()+ " is executing. Incremented value of counter is "+counter.increment());
			}
			
			
		}}
		catch (InterruptedException e) {
			System.out.println("this thread was interrupted. We will stop all processing");
			return;
		}
	
	}

}
