package question1;

public class ThreadForDP implements Runnable{

	@Override
	public void run() {
		Singleton sing = Singleton.getInstance();
		System.out.println(Thread.currentThread().getName()+" : " + sing.hashCode());
	}
	
}
