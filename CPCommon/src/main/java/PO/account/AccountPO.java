package PO.account;

import java.io.Serializable;

public class AccountPO implements Serializable{
	
	private static final long serialVersionUID = -655719656845157677L;
	/**
	 * 账户名称
	 */
	private String accountName;
	/**
	 * 账户余额
	 */
	private double balance;
	
	public AccountPO(){}
	public AccountPO(String accountName, double balance) {
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
