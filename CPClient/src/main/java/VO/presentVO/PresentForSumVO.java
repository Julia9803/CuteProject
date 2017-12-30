package VO.presentVO;

import java.util.Date;
import java.util.List;

import VO.GoodsInSaleVO;

/**     
* @author 李安迪
* @date 2017年10月27日
* @description 赠送策略，针对总价
*/
public class PresentForSumVO extends PresentVO{

//	/**
//	 * 策略类型
//	 */
//	PresentType Sum;
	/**
	 * 总额
	 */
	double total;
	/**
	 *赠品列表
	 */	
	List<GoodsInSaleVO> presentList;
	/**
	 * 赠送代金券金额
	 */
	double voucher;
	
	public PresentForSumVO(int id,Date startTime, Date finishTime, double total,
			List<GoodsInSaleVO> presentList, double voucher) {
		super(id,startTime, finishTime);
		this.total = total;
		this.presentList = presentList;
		this.voucher = voucher;
	}
	



	public double getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getVoucher() {
		return voucher;
	}

	public void setVoucher(int voucher) {
		this.voucher = voucher;
	}


	public List<GoodsInSaleVO> getPresentList() {
		return presentList;
	}


	public void setPresentList(List<GoodsInSaleVO> presentList) {
		this.presentList = presentList;
	}

	

	
	
}
