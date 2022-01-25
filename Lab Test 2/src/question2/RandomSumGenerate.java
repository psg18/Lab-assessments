package question2;

public class RandomSumGenerate {
	public static void main(String[] args) {
		
		RandomSum rs = new RandomSum();
		
		Thread thread1 = new Thread(rs);
		Thread thread2 = new Thread(rs);
		Thread thread3 = new Thread(rs);
		Thread thread4 = new Thread(rs);
		Thread thread5 = new Thread(rs);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();

		System.out.println("Sum : " + rs.getSum());
	}

}