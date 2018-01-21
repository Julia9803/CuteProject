package ui.accountUI;

import VO.accountVO.AccountVO;
import javafx.beans.property.SimpleStringProperty;

public class AccountItem{
	private final SimpleStringProperty accountName;
	private final SimpleStringProperty balance;
	private final SimpleStringProperty deleted;		//删除按钮所在列
	
	public AccountItem(String accountName, String balance){
		this.accountName = new SimpleStringProperty(accountName);
		this.balance = new SimpleStringProperty(balance);
		this.deleted = new SimpleStringProperty("delete");
	}
	
	public AccountItem(AccountVO vo){
		this(vo.getAccountName(),String.valueOf(vo.getBalance()));
	}
	
	public AccountItem(String accountName, double balance){
		this(accountName, String.valueOf(balance));
	}

	public String getAccountName() {
		return accountName.get();
	}
	
	public void setAccountName(String accountName){
		this.accountName.set(accountName);
	}
	
	public String getBalance(){
		return balance.get();
	}
	
	public void setBalance(String balance){
		this.balance.set(balance);
	}

	public String getDeleted(){
		return deleted.get();
	}
	
	public void setDeleted(String deleted){
		this.deleted.set(deleted);
	}
	
	public AccountVO toVO(){
		return new AccountVO(accountName.get(),Double.parseDouble(balance.get()));
	}
	
}
