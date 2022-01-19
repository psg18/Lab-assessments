package question1;

import java.io.*;
import java.util.*;

class SortById implements Comparator<Merchandise>{
	@Override
	public int compare(Merchandise arg0, Merchandise arg1) {
		return arg0.getItemCode().compareTo(arg1.getItemCode());
	}
}

class SortByPrice implements Comparator<Merchandise>{
	@Override
	public int compare(Merchandise arg0, Merchandise arg1) {
		return Double.compare(arg1.getUnitPrice(), arg0.getUnitPrice());
	}
}
public class MerchandiseInventoryTest {
	public static void main(String[] args) {
		List<Merchandise> merchandises = new ArrayList<>();
		File file = new File("C:\\Users\\ve00ym329\\Documents\\assesment\\question1\\src\\question1\\input.dat");
		try(FileReader fr = new FileReader(file)){
			BufferedReader br = new BufferedReader(fr);
			String i = null;
			while((i=br.readLine())!=null) {
				String[] tokens = i.split(" ");
				String itemCode = tokens[0];
				int quantity = Integer.parseInt(tokens[1]);
				double unitPrice = Double.parseDouble(tokens[2]);
				merchandises.add(new Merchandise(itemCode, quantity, unitPrice));
			}
			System.out.println("Sort by ItemID(asc)");
			Collections.sort(merchandises, new SortById());
			for(Merchandise m : merchandises) {
				System.out.println(m.toString());
			}
			System.out.println();
			System.out.println("Sort by Price(dsc)");
			Collections.sort(merchandises, new SortByPrice());
			for(Merchandise m : merchandises) {
				System.out.println(m.toString());
			}
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getStackTrace());
		}
		catch(IOException e) {
			System.out.println(e.getStackTrace());
		}
	}
}
