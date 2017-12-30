package ui.accountUI;

import VO.accountVO.EntryItemVO;
import javafx.beans.property.SimpleStringProperty;

public class EntryItem{
	private final SimpleStringProperty entryName;
	private final SimpleStringProperty amount;
	private final SimpleStringProperty note;
	private final SimpleStringProperty deleted;		//删除按钮所在列
	
	public EntryItem(String entryName, String amount, String note){
		this.entryName = new SimpleStringProperty(entryName);
		this.amount = new SimpleStringProperty(amount);
		this.note = new SimpleStringProperty(note);
		this.deleted = new SimpleStringProperty("delete");
	}
	
	public EntryItem(EntryItemVO vo){
		this(vo.getEntryName(),String.valueOf(vo.getAmount()),vo.getNote());
	}
	
	public EntryItem(String entryName, double amount, String note){
		this(entryName, String.valueOf(amount), note);
	}

	public String getEntryName() {
		return entryName.get();
	}
	
	public void setEntryName(String entryName){
		this.entryName.set(entryName);
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
	
	public EntryItemVO toVO(){
		return new EntryItemVO(entryName.get(),Double.parseDouble(amount.get()),note.get());
	}
	
}
