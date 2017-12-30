package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import util.State;
import util.UserGrade;

public class SalesmanListPO extends ListPO{
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

	


}
