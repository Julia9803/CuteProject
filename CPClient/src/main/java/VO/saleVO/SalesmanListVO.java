package VO.saleVO;

import java.util.List;

import VO.ListVO;
import util.State;
import util.UserGrade;

public abstract class SalesmanListVO extends ListVO{
	/**
	 * 操作员等级 
	 */
	UserGrade operatorGrade;
	/**
	  * 客户编号
	  */
	 String memberID;
	/**
	  * 客户名
	  */
	 String memberName;
	 /**
	  * 客户等级
	  */
	 
	 /**
	  * 业务员名字
	  */
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
	 List<SalesmanItemVO> SaleListItems;
	 /**
	  * 最终金额
	  */
	 double sum;
//	  double priceBeforeDiscount; //折让前总额
//	  double discount;//销售人员折让
//	  double voucher;//代金券数额
//	  double finalPrice;
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
	public void setRealOperator(String operator) {
		this.realOperator = operator;
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
	public List<SalesmanItemVO> getSaleListItems() {
		return SaleListItems;
	}
	public void setSaleListItems(List<SalesmanItemVO> saleListItems) {
		SaleListItems = saleListItems;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public SalesmanListVO(String id, String operator, String operatorId, State state,UserGrade operatorGrade,String memberID,
			String memberName, String realOperator, String warehouse, String notes, List<SalesmanItemVO> saleListItems,
			double sum) {
		super(id, operator, operatorId, state);
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
}