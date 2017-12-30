package VO.presentVO;

import java.util.Date;
import java.util.List;

import VO.GoodsInSaleVO;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年10月26日
* @description 针对不同级别的用户制定促销策略（赠品、价格折让、 赠送代金劵）
*/
public class PresentForMembershipVO extends PresentVO{

//	/**
//	 * 策略类型
//	 */
//	PresentType Membership;
	/**
	 *会员级别
	 */	
	VIPGrade grade;
	/**
	 *总额
	 */	
	double sum;
	/**
	 *赠品列表
	 */	
	List<GoodsInSaleVO> presentList;
	/**
	 *折让价格
	 */	
	double rebateInPresentForMembership;
	/**
	 *赠送代金券金额
	 */	
	double voucher;

	public VIPGrade getGrade() {
		return grade;
	}

	public void setGrade(VIPGrade grade) {
		this.grade = grade;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public List<GoodsInSaleVO> getPresentList() {
		return presentList;
	}

	public void setPresentList(List<GoodsInSaleVO> presentList) {
		this.presentList = presentList;
	}

	public double getRebateInPresentForMembership() {
		return rebateInPresentForMembership;
	}

	public void setRebateInPresentForMembership(double rebateInPresentForMembership) {
		this.rebateInPresentForMembership = rebateInPresentForMembership;
	}

	public double getVoucher() {
		return voucher;
	}

	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}

	public PresentForMembershipVO(int id,  Date startTime, Date finishTime,
			 VIPGrade grade, double sum, List<GoodsInSaleVO> presentList,
			double rebateInPresentForMembership, double voucher) {
		super(id, startTime, finishTime);
		this.grade = grade;
		this.sum = sum;
		this.presentList = presentList;
		this.rebateInPresentForMembership = rebateInPresentForMembership;
		this.voucher = voucher;
	}
	


	
}
