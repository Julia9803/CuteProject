package PO.account;

import java.io.Serializable;

public class EntryItemPO implements Serializable{
	
	private static final long serialVersionUID = -9171419662019332903L;
	private int autoId;	//数据库中自动生成的id
	private String entryName;
	private double amount;
	private String note;
	
	public EntryItemPO(){}
	public EntryItemPO(String entryName, double amount, String note){
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
	public int getAutoId() {
		return autoId;
	}
	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}
}
