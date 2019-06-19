
package dev.abhinav.threading;

/**
 * @author abhinav
 *
 */
public class ThreadB2_2 extends Thread {

	private Counter counter;

	public ThreadB2_2(Counter counter) {
		this.counter = counter;
		this.setName("ThreadB");
	}

	@Override
	public void run() {
		try {

			// Starts by running for 5 seconds
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				synchronized (counter) {
					System.out.println(
							Thread.currentThread().getName() + " is executing. decremented value of counter is " + counter.decrement());
				}

			}
			
			Thread.sleep(5000);
			
			for (int i = 0; i < 14; i++) {
				Thread.sleep(1000);
				synchronized (counter) {
					System.out.println(
							Thread.currentThread().getName() + " is executing. decremented value of counter is " + counter.decrement());
				}

			}
			//this thread is done with it's work
			synchronized (counter) {
				counter.notify(); //wake up only one of the threads waiting on the counter object	
			}
			

		} catch (InterruptedException e) {
			System.out.println("ThreadB was interrupted");
			return;
		}
	}
}
