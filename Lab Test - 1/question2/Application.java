package question2;

public class Application {
	public static void main(String[] args) {
		Date date1 = new Date(8,7,2000);
		
		Owner owner = new Owner("Paras Gupta",date1,"YM329");
		
		SavingAccount account = new SavingAccount();
		account.setBalance(20000);
		account.setNumber("76453");
		account.setOwner(owner);
		account.setInterestRate(5);
		account.print();
		account.deposit(500);
		account.withdraw(500.50f);
		
		CurrentAccount account2 = new CurrentAccount();
		account2.setBalance(30000);
		account2.setOwner(owner);
		account2.setNumber("94764");
		account2.setMinimumBalance(10000);
		account2.print();
		account2.withdraw(9000);
		account2.withdraw(40000);
		account2.deposit(15000);
		
		
	}
}
