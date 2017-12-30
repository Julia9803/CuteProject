package PO;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.Date;
import java.util.List;

import util.PresentState;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 赠送策略，针对总价
*/
public class PresentForSumPO extends PresentPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5139108421227021591L;
	/**
	 * 
	 */

	public PresentForSumPO(){}
	public PresentForSumPO(int id,Date startTime, Date finishTime, double sum, List<GoodsInSalePO> presentList,
			PresentState state,double voucher) {
		super(id,startTime, finishTime,presentList,state);
		this.sum = sum;
		this.presentList = presentList;
		this.voucher = voucher;
	}
	/**
	 * 总额
	 */
	double sum;
	/**
	 * 赠送代金券金额
	 */
	double voucher;
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
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
		long temp;
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
		PresentForSumPO other = (PresentForSumPO) obj;
		if (Double.doubleToLongBits(sum) != Double.doubleToLongBits(other.sum))
			return false;
		if (Double.doubleToLongBits(voucher) != Double.doubleToLongBits(other.voucher))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PresentForSumPO [sum=" + sum + ", voucher=" + voucher + ", id=" + id + ", startTime=" + startTime.toString()
				+ ", finishTime=" + finishTime.toString() + ", presentList=" + presentList + ", state=" + state + "]";
	}
	
	
}
