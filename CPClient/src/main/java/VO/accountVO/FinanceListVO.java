package VO.accountVO;

import VO.ListVO;

public abstract class FinanceListVO extends ListVO{
	private double totalAmount;

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
