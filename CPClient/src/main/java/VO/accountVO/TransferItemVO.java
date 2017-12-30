package VO.accountVO;

public class TransferItemVO {
	private String account;
	private double amount;
	private String note;
	
	public TransferItemVO(String account, double amount, String note){
		this.account = account;
		this.amount = amount;
		this.note = note;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
