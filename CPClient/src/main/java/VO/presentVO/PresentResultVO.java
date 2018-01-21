package VO.presentVO;

import java.util.List;

import VO.GoodsInSaleVO;

/**     
* @author 李安迪
* @date 2017年11月9日
* @description 销售中返回给界面的赠送结果
*/
public class PresentResultVO {
	int id;
	/**
	 * 策略id列表,点击id可以查看详情
	 */
	List<Integer> presentId;
//	/**
//	 * 价格折让
//	 */
//	double price_discount;
	/**
	 * 赠送代金券金额
	 */
	double voucher;
//	/**
//	 * 特价商品列表
//	 */
//	List<GoodsInSaleVO> goodsList;
	/**
	 *赠品列表
	 */	
	List<GoodsInSaleVO> presentList;
	/**
	 *使用赠送策略后总价
	 */	
	double sum;
	public List<Integer> getPresentId() {
		return presentId;
	}
	public void setPresentId(List<Integer> presentId) {
		this.presentId = presentId;
	}
//	public double getPrice_discount() {
//		return price_discount;
//	}
//	public void setPrice_discount(double price_discount) {
//		this.price_discount = price_discount;
//	}
	public double getVoucher() {
		return voucher;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}
	public List<GoodsInSaleVO> getPresentList() {
		return presentList;
	}
	public void setPresentList(List<GoodsInSaleVO> presentList) {
		this.presentList = presentList;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public PresentResultVO(List<Integer> presentId, double voucher,
			List<GoodsInSaleVO> presentList, double sum) {
		super();
		this.presentId = presentId;
//		this.price_discount = price_discount;
		this.voucher = voucher;
		this.presentList = presentList;
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "PresentResultVO [id=" + id + ", presentId=" + presentId + ", voucher=" + voucher + ", presentList="
				+ presentList + ", sum=" + sum + "]";
	}
	
	
}

