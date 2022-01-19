package question2;

public class Account {
	
	private Owner owner;
	private float balance;
	private String number;
	
	public Account() {
	}
	public Account(Owner owner, float balance, String number) {
		this.owner = owner;
		this.balance = balance;
		this.number = number;
	}
	public Account(Account account) {
		this.owner = account.owner;
		this.balance = account.balance;
		this.number = account.number;
	}
	
	public void print() {
		owner.print();
		System.out.println("Account number: " + this.number+"\nBalance: " + this.balance );
	}
	
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "Account [owner=" + owner + ", balance=" + balance + ", number=" + number + "]";
	}
	
	public void deposit(float amount) {}
	
	public void withdraw(float amount){}

	public float getBalance() {
		return balance;
	}	
}
