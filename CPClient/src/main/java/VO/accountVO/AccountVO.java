package VO.accountVO;

public class AccountVO {
	
	private String accountName;
	
	private double balance;

	public AccountVO(String accountName, double balance){
		this.accountName = accountName;
		this.balance = balance;
	}
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
}
