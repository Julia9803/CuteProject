package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import util.PresentState;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 赠送策略。特价包
*/
public class PresentForSpecialPackagePO extends PresentPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1700301293157435401L;

	public PresentForSpecialPackagePO(int id,Date startTime, Date finishTime, List<GoodsInSalePO> presentList,
			PresentState state,double priceReduction) {
		super(id,startTime, finishTime,presentList,state);
		this.priceReduction = priceReduction;
	}
	public PresentForSpecialPackagePO(){}
	/**
	 *降价金额
	 */	
	double priceReduction;

	public double getPriceReduction() {
		return priceReduction;
	}
	public void setPriceReduction(double priceReduction) {
		this.priceReduction = priceReduction;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(priceReduction);
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
		PresentForSpecialPackagePO other = (PresentForSpecialPackagePO) obj;
		if (Double.doubleToLongBits(priceReduction) != Double.doubleToLongBits(other.priceReduction))
			return false;
		return true;
	}


}
