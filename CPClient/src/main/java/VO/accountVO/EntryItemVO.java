package VO.accountVO;

public class EntryItemVO {
	private String entryName;
	private double amount;
	private String note;
	
	public EntryItemVO(String entryName, double amount, String note){
		this.entryName = entryName;
		this.amount = amount;
		this.note = note;
	}
	public String getEntryName() {
		return entryName;
	}
	public void setEntryName(String entryName) {
		this.entryName = entryName;
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
