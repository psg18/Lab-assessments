package question2;

public class CurrentAccount extends Account {

	private float minimumBalance;

	public CurrentAccount() {
	}

	public CurrentAccount(CurrentAccount ca) {
		super(ca);
		this.minimumBalance = ca.minimumBalance;
	}
	public void setMinimumBalance(float minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	@Override
	public void withdraw(float amount) {
		float balance = getBalance() - amount;
		if (balance > minimumBalance) {
			setBalance(balance);
			System.out.println("Withdrawal successful");
		} else {
			System.out.println("Unable to withdraw the amount!!!!");
		}
	}
	@Override
	public void print() {
		System.out.println("\nCurrent Account:");
		super.print();
		System.out.println("Minimum balance to be : " + this.minimumBalance+"\n");
	}

	@Override
	public void deposit(float amount) {
		setBalance(getBalance()+amount);
		System.out.println("Deposit Successfull!");
	}
	
	public float getCharges() {
		return (float)(minimumBalance*0.1);
	}

	@Override
	public String toString() {
		return "CurrentAccount [minimumBalance=" + minimumBalance + "]";
	}
	

}
