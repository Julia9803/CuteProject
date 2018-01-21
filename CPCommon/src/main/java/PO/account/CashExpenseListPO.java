package PO.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.State;

public class CashExpenseListPO extends FinanceListPO{
	
	
	private static final long serialVersionUID = -1559858934627025138L;
	private String account;
	private List<EntryItemPO> entryItem;
	
	public CashExpenseListPO(){}
	public CashExpenseListPO(String listId,String operator, String operatorId, State state,
			String account, List<EntryItemPO> entryItem, double totalAmount, Date day){
		setId(listId);
		setOperator(operator);
		setOperatorId(operatorId);
		setState(state);
		setAccount(account);
		setEntryItem(entryItem);
		setTotalAmount(totalAmount);
		setDay(day);
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public List<EntryItemPO> getEntryItem() {
		if(entryItem == null)
			return null;
		else
			return new ArrayList<EntryItemPO>(entryItem);
	}
	public void setEntryItem(List<EntryItemPO> entryItem) {
		if(entryItem == null)
			this.entryItem = null;
		else
			this.entryItem = new ArrayList<EntryItemPO>(entryItem);
	}
}
