package VO.saleVO;

import java.util.List;

import VO.presentVO.PresentResultVO;
import util.State;
import util.UserGrade;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 销售单
*/
public class SaleListVO extends SalesmanListVO{
	SalesmanListType type = SalesmanListType.SaleList;
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
	 /**
	  * 客户等级
	  */
	 VIPGrade memberGrade;
	/**
	 * 赠品情况
	 */
	PresentResultVO presentResultVO;

	public PresentResultVO getPresentResultVO() {
		return presentResultVO;
	}
	public void setPresentResultVO(PresentResultVO presentResultVO) {
		this.presentResultVO = presentResultVO;
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
	public VIPGrade getGrade() {
		return memberGrade;
	}
	public void setGrade(VIPGrade grade) {
		this.memberGrade = grade;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}
	public SaleListVO(String id, String operator, String operatorId, State state,UserGrade operatorGrade,String memberID, String memberName,
			VIPGrade grade,String operator2, String warehouse, String notes, List<SalesmanItemVO> saleListItems, double sum,
			double sumBeforeRebate, double rebate, double voucher,PresentResultVO vo) {
		super(id, operator, operatorId, state, operatorGrade,memberID, memberName, operator2, warehouse, notes, saleListItems, sum);
		this.sumBeforeRebate = sumBeforeRebate;
		this.rebate = rebate;
		this.voucher = voucher;
		this.presentResultVO = vo;
		this.memberGrade = grade;
	}

	
	
	
}
