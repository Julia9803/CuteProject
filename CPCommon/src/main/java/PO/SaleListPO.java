package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import util.State;
import util.UserGrade;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description
*/
public class SaleListPO extends SalesmanListPO implements Serializable{
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
	public SaleListPO(){}
	





	public SaleListPO(String id, State state, Date day, UserGrade operatorGrade,String memberID, String memberName,String operator,String operatorId,
			String realOperator, String warehouse, String notes, List<SalesmanItemPO> saleListItems, double sum,
			double sumBeforeRebate, double rebate, double voucher) {
		super(id, state, day, operatorGrade,memberID, memberName,operator,operatorId,realOperator, warehouse, notes, saleListItems, sum);
		this.sumBeforeRebate = sumBeforeRebate;
		this.rebate = rebate;
		this.voucher = voucher;
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
