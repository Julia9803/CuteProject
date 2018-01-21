package PO;

import java.util.Date;
import java.util.List;

import util.State;
import util.UserGrade;

public class SalesmanListPO extends ListPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8104130091130040289L;

	/**
	 * 操作员等级
	 */
	private UserGrade operatorGrade;

	/**
	  * 客户编号
	  */
	 String memberID;
	/**
	  * 客户名
	  */
	 String memberName;

	 //业务员名字
	 String realOperator;
	 
	 // ListState state;
	 /**
	  * 仓库名字
	  */
	 String warehouse = "默认仓库";
	 /**
	  * 备注
	  */	 
	 String notes; 
	 /**
	  * 商品清单
	  */
	 List<SalesmanItemPO> SaleListItems;
	 /**
	  * 最终金额
	  */
	 double sum;

	 public SalesmanListPO(){};
	 public SalesmanListPO(String id, State state, Date day,UserGrade operatorGrade, String memberID, String memberName,String operator,String operatorId
			,String realOperator, String warehouse, String notes, List<SalesmanItemPO> saleListItems, double sum) {
		super(id,operator,operatorId,state,day);
		this.operatorGrade = operatorGrade;
		this.memberID = memberID;
		this.memberName = memberName;
		this.realOperator = realOperator;
		this.warehouse = warehouse;
		this.notes = notes;
		SaleListItems = saleListItems;
		this.sum = sum;
	}

	public UserGrade getOperatorGrade() {
		return operatorGrade;
	}

	public void setOperatorGrade(UserGrade operatorGrade) {
		this.operatorGrade = operatorGrade;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getRealOperator() {
		return realOperator;
	}

	public void setRealOperator(String realOperator) {
		this.realOperator = realOperator;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<SalesmanItemPO> getSaleListItems() {
		return SaleListItems;
	}

	public void setSaleListItems(List<SalesmanItemPO> saleListItems) {
		SaleListItems = saleListItems;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((SaleListItems == null) ? 0 : SaleListItems.hashCode());
		result = prime * result + ((memberID == null) ? 0 : memberID.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((operatorGrade == null) ? 0 : operatorGrade.hashCode());
		result = prime * result + ((realOperator == null) ? 0 : realOperator.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((warehouse == null) ? 0 : warehouse.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesmanListPO other = (SalesmanListPO) obj;
		if (SaleListItems == null) {
			if (other.SaleListItems != null)
				return false;
		} else if (!SaleListItems.equals(other.SaleListItems))
			return false;
		if (memberID == null) {
			if (other.memberID != null)
				return false;
		} else if (!memberID.equals(other.memberID))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (operatorGrade != other.operatorGrade)
			return false;
		if (realOperator == null) {
			if (other.realOperator != null)
				return false;
		} else if (!realOperator.equals(other.realOperator))
			return false;
		if (Double.doubleToLongBits(sum) != Double.doubleToLongBits(other.sum))
			return false;
		if (warehouse == null) {
			if (other.warehouse != null)
				return false;
		} else if (!warehouse.equals(other.warehouse))
			return false;
		return true;
	}

	


}
