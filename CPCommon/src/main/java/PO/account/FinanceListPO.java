package PO.account;

import PO.ListPO;

public abstract class FinanceListPO extends ListPO{
	
	private static final long serialVersionUID = -237146895007977834L;
	private double totalAmount;

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public FinanceListPO(){}
}
