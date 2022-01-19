package question2;

public class SavingAccount extends Account {

	private float interestRate;

	public SavingAccount() {
	}

	public SavingAccount(SavingAccount sa) {
		super(sa);
		this.interestRate = sa.interestRate;
	}

	public float getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	@Override
	public void print() {
		System.out.println("Saving Account: ");
		super.print();
		System.out.println("Interest rate: " + this.interestRate+"\n");
	}

	@Override
	public String toString() {
		return "SavingAccount [interestRate=" + interestRate + "]";
	}

	@Override
	public void withdraw(float amount) {

		float balance = getBalance() - amount;
		if (balance > 0) {
			setBalance(balance);
			System.out.println("Withdrawal successful");
		} else {
			System.out.println("Unable to withdraw the amount!!!!");
		}
	}
	
	@Override
	public void deposit(float amount) {
		setBalance(getBalance()+amount);
		System.out.println("Deposit Successfull!");
	}


	public float getInterest() {
		return interestRate*this.getBalance();
	}

	
}
