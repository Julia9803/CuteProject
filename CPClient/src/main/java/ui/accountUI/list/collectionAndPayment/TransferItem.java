package ui.accountUI.list.collectionAndPayment;

import VO.accountVO.TransferItemVO;
import javafx.beans.property.SimpleStringProperty;

public class TransferItem{
	private final SimpleStringProperty account;
	private final SimpleStringProperty amount;
	private final SimpleStringProperty note;
	private final SimpleStringProperty deleted;		//删除按钮所在列
	
	public TransferItem(String account, String amount, String note){
		this.account = new SimpleStringProperty(account);
		this.amount = new SimpleStringProperty(amount);
		this.note = new SimpleStringProperty(note);
		this.deleted = new SimpleStringProperty("delete");
	}
	
	public TransferItem(TransferItemVO vo){
		this(vo.getAccount(),String.valueOf(vo.getAmount()),vo.getNote());
	}
	
	public TransferItem(String account, double amount, String note){
		this(account, String.valueOf(amount), note);
	}

	public String getAccount() {
		return account.get();
	}
	
	public void setAccount(String account){
		this.account.set(account);
	}
	
	public String getAmount(){
		return amount.get();
	}
	
	public void setAmount(String amount){
		this.amount.set(amount);
	}
	
	public String getNote(){
		return note.get();
	}
	
	public void setNote(String note){
		this.note.set(note);
	}
	
	public String getDeleted(){
		return deleted.get();
	}
	
	public void setDeleted(String deleted){
		this.deleted.set(deleted);
	}
	
	public TransferItemVO toVO(){
		return new TransferItemVO(account.get(),Double.parseDouble(amount.get()),note.get());
	}
	
}
