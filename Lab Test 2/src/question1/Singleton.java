package question1;

import java.io.Serializable;

public class Singleton implements Cloneable,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	Eager Initialization
//	private static Singleton instance = new Singleton();
	
	
	private static Singleton instance = null;

	
//  static block initialization
//	static {
//		try {
//			instance = new Singleton();
//		} catch (Exception e) {
//			throw new RuntimeException("Error in Static Block Initialization");
//		}
//	}
	
	
	//
	private Singleton() throws IllegalStateException{
		if(instance != null) {
			throw new IllegalStateException();
		}
		System.out.println("Instance Created");
	}
	
// Thread Safe - Lazy Initialization with Double checking 
	public static  Singleton getInstance() {
		if(instance==null) {	
			synchronized(Singleton.class) {//double check locking
				if(instance==null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	

	
	protected Object readResolve() {
		return instance;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
//		throw new CloneNotSupportedException(); // or return instance;
		return instance;
	}

}


