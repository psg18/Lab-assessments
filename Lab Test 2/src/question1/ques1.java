package question1;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ques1 {

	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		//Lazy Initialization with Double checking 
		Singleton sing = Singleton.getInstance();
		System.out.println("Lazy Instantiation : " + sing.hashCode());

		
		//Thread safe
		ThreadForDP tfdp1 = new ThreadForDP();
		Thread t1 = new Thread(tfdp1);
		ThreadForDP tfdp2 = new ThreadForDP();
		Thread t2 = new Thread(tfdp2);
		
		t1.start();
		t2.start();
		
		
		//Serialization
		File file = new File("C:\\Users\\ve00ym329\\Documents\\jdbc\\lab-assessment2\\src\\question1\\Sample");
		
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream bos = new ObjectOutputStream(fos);
		bos.writeObject(sing);
		bos.close();
		
		FileInputStream fis = new FileInputStream(file);
		
		try (ObjectInputStream ois = new ObjectInputStream(fis)) {
			Singleton sing2 = (Singleton)ois.readObject();
			System.out.println("Serialization : " + sing2.hashCode());
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}

		
		//cloning
		try {
			Singleton sing3 = (Singleton)sing.clone();
			System.out.println("Cloning : " + sing3.hashCode());

		}
		catch(CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		
		
		//ENUM
		SingletonEnum enum1 = SingletonEnum.INSTANCE;
		SingletonEnum enum2 = SingletonEnum.INSTANCE;
		System.out.println();
		System.out.println("Enum 1 : "+ enum1.hashCode());
		System.out.println("Enum 2 : "+ enum2.hashCode()+"\n");
		
		//Reflection API
		try {
			Constructor[] cons = Singleton.class.getDeclaredConstructors();
			for( Constructor con : cons) {
				con.setAccessible(true);
				Singleton sing5 = (Singleton) con.newInstance(); 
				System.out.println("sing5 : " + sing5.hashCode());
			}
		}
		catch(IllegalStateException e) {
			System.out.println(e.getMessage());
		}

	}

}
