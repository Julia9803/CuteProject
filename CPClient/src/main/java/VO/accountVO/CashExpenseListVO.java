package VO.accountVO;

import java.util.ArrayList;
import java.util.List;

import util.State;

public class CashExpenseListVO extends FinanceListVO{
	private String account;
	private List<EntryItemVO> entryItem;
	
	public CashExpenseListVO(String listId,String operator, String operatorId, State state,
			String account, List<EntryItemVO> entryItem, double totalAmount){
		setId(listId);
		setOperator(operator);
		setOperatorId(operatorId);
		setState(state);
		setAccount(account);
		setEntryItem(entryItem);
		setTotalAmount(totalAmount);
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public List<EntryItemVO> getEntryItem() {
		if(entryItem == null)
			return null;
		else
			return new ArrayList<EntryItemVO>(entryItem);
	}
	public void setEntryItem(List<EntryItemVO> entryItem) {
		if(entryItem == null)
			this.entryItem = null;
		else
			this.entryItem = new ArrayList<EntryItemVO>(entryItem);
	}
}
