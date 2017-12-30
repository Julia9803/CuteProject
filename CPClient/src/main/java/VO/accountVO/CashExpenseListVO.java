package VO.accountVO;

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
		return entryItem;
	}
	public void setEntryItem(List<EntryItemVO> entryItem) {
		this.entryItem = entryItem;
	}
}
