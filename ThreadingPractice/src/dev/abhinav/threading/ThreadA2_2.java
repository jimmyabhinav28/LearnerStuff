/**
 * 
 */
package dev.abhinav.threading;

/**
 * @author abhinav
 *
 */
public class ThreadA2_2 extends Thread {

	private Counter counter;
	private int startRunDurationInSeconds;

	public ThreadA2_2(Counter counter, int startRunDurationInSeconds) {
		this.counter = counter;
		this.startRunDurationInSeconds = startRunDurationInSeconds;
		this.setName("ThreadA");
	}

	@Override
	public void run() {
		try {

			// Starts by running for 5 seconds
			for (int i = 0; i < startRunDurationInSeconds; i++) {
				Thread.sleep(1000);
				synchronized (counter) {
					System.out.println(
							this.getName() + " is executing. Incremented value of counter is " + counter.increment());
				}

			}
			// now pause for 5 seconds
			Thread.sleep(5000);

			// wait for any other thread to notify the counter
			synchronized (counter) {
				counter.wait();	
			}
			

			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				synchronized (counter) {
					System.out.println(Thread.currentThread().getName()
							+ " is executing. Incremented value of counter is " + counter.increment());
				}

			}
		} catch (InterruptedException e) {
			System.out.println("this thread was interrupted. We will stop all processing");
			return;
		}

	}

}
