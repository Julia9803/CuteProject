package VO.saleVO;

import java.util.List;

import util.State;
import util.UserGrade;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 销售退货单
*/
public class SaleReturnListVO extends SalesmanListVO{
	
	/**
	 * 单据类型
	 */
	SalesmanListType type = SalesmanListType.SaleReturnList;
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
	public SalesmanListType getType() {
		return type;
	}
	public void setType(SalesmanListType type) {
		this.type = type;
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
	public SaleReturnListVO(String id, String operator, String operatorId, State state,UserGrade operatorGrade, String memberID,
			String memberName, String realOperator, String warehouse, String notes, List<SalesmanItemVO> saleListItems,
			double sum, double sumBeforeRebate, double rebate, double voucher) {
		super(id, operator, operatorId, state,operatorGrade,memberID, memberName, realOperator, warehouse, notes, saleListItems,
				sum);
		this.sumBeforeRebate = sumBeforeRebate;
		this.rebate = rebate;
		this.voucher = voucher;
	}
	
}
