package VO.presentVO;

import java.util.Date;
import java.util.List;

import VO.GoodsInSaleVO;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 赠送策略。特价包
*/
public class PresentForSpecialPackageVO extends PresentVO{

//	/**
//	 * 策略类型
//	 */
//	PresentType SpecialPackage;
	/**
	 *商品列表，每个策略里只有一个特价包
	 */	
	List<GoodsInSaleVO> presentList;
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


	public List<GoodsInSaleVO> getPresentList() {
		return presentList;
	}


	public void setPresentList(List<GoodsInSaleVO> presentList) {
		this.presentList = presentList;
	}


	public PresentForSpecialPackageVO(int id, Date startTime, Date finishTime,
			List<GoodsInSaleVO> goodsList, double priceReduction) {
		super(id, startTime, finishTime);
//		SpecialPackage = specialPackage;
		this.presentList = goodsList;
		this.priceReduction = priceReduction;
	}


	@Override
	public String toString() {
		
		return super.toString() + "PresentForSpecialPackageVO [presentList=" + presentList + ", priceReduction=" + priceReduction + "]";
	}


	
}
