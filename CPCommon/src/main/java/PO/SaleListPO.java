package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import util.State;
import util.UserGrade;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class SaleListPO extends SalesmanListPO implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -8365230385421781739L;
public VIPGrade getMemberGrade() {
		return memberGrade;
	}




	public void setMemberGrade(VIPGrade memberGrade) {
		this.memberGrade = memberGrade;
	}

	//	/**
//	 * 单据编号
//	 */
//	String id;
	/**
	 * 折让前总额
	 */
	double sumBeforeRebate;
	/**
	 * 折让
	 */
	double rebate;
	/**
	 * 使用代金券金额
	 */
	double voucher;
	PresentResultPO presentResultPO;
	public SaleListPO(){}
	
	 /**
	  * 客户等级
	  */
	 VIPGrade memberGrade;




	public SaleListPO(String id, State state, Date day, UserGrade operatorGrade,String memberID, String memberName,VIPGrade memberGrade,String operator,String operatorId,
			String realOperator, String warehouse, String notes, List<SalesmanItemPO> saleListItems, double sum,
			double sumBeforeRebate, double rebate, double voucher,PresentResultPO po) {
		super(id, state, day, operatorGrade,memberID, memberName,operator,operatorId,realOperator, warehouse, notes, saleListItems, sum);
		this.memberGrade = memberGrade;
		this.sumBeforeRebate = sumBeforeRebate;
		this.rebate = rebate;
		this.voucher = voucher;
		this.presentResultPO = po;
	}




	@Override
	public String toString() {
		return "SaleListPO [sumBeforeRebate=" + sumBeforeRebate + ", rebate=" + rebate + ", voucher=" + voucher
				+ ", presentResultPO=" + presentResultPO + ", memberGrade=" + memberGrade + "]";
	}




	public VIPGrade getGrade() {
		return memberGrade;
	}
	public void setGrade(VIPGrade grade) {
		this.memberGrade = grade;
	}

	public PresentResultPO getPresentResultPO() {
		return presentResultPO;
	}






	public void setPresentResultPO(PresentResultPO presentResultPO) {
		this.presentResultPO = presentResultPO;
	}






	public double getSumBeforeRebate() {
		return sumBeforeRebate;
	}
	public void setSumBeforeRebate(double sumBeforeRebate) {
		this.sumBeforeRebate = sumBeforeRebate;
	}
	public double getRebate() {
		return rebate;
	}
	public void setRebate(double rebate) {
		this.rebate = rebate;
	}
	public double getVoucher() {
		return voucher;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
	
}
