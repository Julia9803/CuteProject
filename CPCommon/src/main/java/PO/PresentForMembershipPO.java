package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import util.PresentState;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年10月26日
* @description 针对不同级别的用户制定促销策略（赠品、价格折让、 赠送代金劵）
*/
public class PresentForMembershipPO extends PresentPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3809196455229133401L;
	public PresentForMembershipPO(){}
	public PresentForMembershipPO(int id,Date startTime, Date finishTime, double sum, List<GoodsInSalePO> presentList,
			PresentState state,double voucher,VIPGrade grade,double rebateInPresentForMembership) {
		super(id,startTime, finishTime,presentList,state);
		this.grade = grade;
		this.sum = sum;
		this.rebateInPresentForMembership = rebateInPresentForMembership;
		this.voucher = voucher;
	}
	/**
	 *会员级别
	 */	
	VIPGrade grade;
	/**
	 *总额
	 */	
	double sum;

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rebateInPresentForMembership);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(voucher);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		PresentForMembershipPO other = (PresentForMembershipPO) obj;
		if (grade != other.grade)
			return false;
		if (Double.doubleToLongBits(rebateInPresentForMembership) != Double
				.doubleToLongBits(other.rebateInPresentForMembership))
			return false;
		if (Double.doubleToLongBits(sum) != Double.doubleToLongBits(other.sum))
			return false;
		if (Double.doubleToLongBits(voucher) != Double.doubleToLongBits(other.voucher))
			return false;
		return true;
	}

	
	
}
