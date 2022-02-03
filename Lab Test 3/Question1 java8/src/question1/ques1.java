package question1;

import java.util.HashMap;
import java.util.Map;

public class ques1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("raj", 95);
		map.put("ekta", 75);
		map.put("rajiv", 85);
		map.put("sunita", 66);
		map.put("gunika", 99);

		// 1. print map using stream
		map.entrySet().stream().forEach(System.out::println);
		

		// 2. print only that records that contain key contains raj
		map.entrySet().stream().filter(e -> e.getKey().contains("raj")).forEach(System.out::println);
		

		// 3. print map sorted by key
		map.entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
				.forEach(System.out::println);
		
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		

		// 4. print map sorted by values
		map.entrySet().stream().sorted((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()))
				.forEach(System.out::println);
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		

		// 5. print map reverse sorted by the key
		map.entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(System.out::println);
		
		
		

		// HashMap with user defined key
		Map<Student, Integer> studentMap = new HashMap<>();
		studentMap.put(new Student(109, "raj", 95), 95);
		studentMap.put(new Student(61, "keta", 78), 78);
		studentMap.put(new Student(11, "gunika", 98), 98);
		studentMap.put(new Student(19, "keshav", 97), 97);
		

		// 1. Print all records sorted as per name of the student
		studentMap.entrySet().stream().sorted((s1, s2) -> s1.getKey().getName().compareTo(s2.getKey().getName()))
				.forEach(System.out::println);

		
		// 2. Print all records as per id of the student
		studentMap.entrySet().stream().sorted((s1, s2) -> Integer.compare(s1.getKey().getId(), s2.getKey().getId()))
				.forEach(System.out::println);

	}

}
