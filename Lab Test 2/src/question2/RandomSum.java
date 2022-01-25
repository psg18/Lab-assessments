package question2;

import java.util.Random;

public class RandomSum implements Runnable {
	Random random = new Random();
	private int total_sum;

	private boolean isDone = false;
	int count = 0;

	@Override
	public void run() {
		
		int num = random.nextInt(10) + 1;
		System.out.println(Thread.currentThread().getName() +" -> " + num);
		
		count++;
		total_sum  += num;
		
		if (count == 5) {
			isDone = true;
			synchronized (this) {
				notifyAll();
			}
		}
	}

	public synchronized int getSum() {
		
		if (!isDone) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		return total_sum;
	}
}
