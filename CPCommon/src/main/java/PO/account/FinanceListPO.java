package PO.account;

import PO.ListPO;

public abstract class FinanceListPO extends ListPO{
	private double totalAmount;

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
